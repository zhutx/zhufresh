package com.moredian.tuna.certification.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.dubbo.rpc.RpcException;
import com.moredian.bee.common.exception.BizException;
import com.moredian.bee.common.exception.CommonErrorCode;
import com.moredian.bee.common.utils.JsonUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.tuna.certification.model.SessionUser;

@Controller
public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler()
	public String handleException(Exception exception, HttpServletRequest request, HttpServletResponse response) {
		
		String errorCode = CommonErrorCode.UNKONWN.getCode();
		String message = CommonErrorCode.UNKONWN.getMessage();
		if(exception instanceof BizException){
			BizException bizException = (BizException)exception;
			errorCode = bizException.getErrorContext().getCode();
			message = bizException.getErrorContext().getMessage();
			logger.error(message);
		} else if(exception instanceof RpcException){
			logger.error("服务调用失败",exception);
			message = "服务调用失败";
		} else {
			logger.error(exception.getMessage(), exception);
		}
		
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			BaseResponse baseResponse = new BaseResponse(errorCode, message);
			writer.write(JsonUtils.toJson(baseResponse));
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	protected SessionUser getSessionUser(HttpServletRequest request) {
		String sessionId = "EA043C4DF684812AAAE8EDDEF629688E";
//		String value = stringRedisTemplate.opsForValue().get(request.getSession().getId());
		String value = stringRedisTemplate.opsForValue().get(sessionId);
		return JsonUtils.fromJson(SessionUser.class, value);
	}
	
}
