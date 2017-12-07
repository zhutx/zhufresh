package com.moredian.zhufresh.config;

import com.moredian.bee.common.utils.JsonUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.zhufresh.utils.AuthorizeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(MyWebMvcConfigurerAdapter.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/checkCode","/user/register","/user/login");
        super.addInterceptors(registry);
    }
    
    public class AuthInterceptor extends HandlerInterceptorAdapter {
		
    	@Override
    	public boolean preHandle(HttpServletRequest request,
    			HttpServletResponse response, Object handler) throws Exception {

    		logger.info("------------URI: "+request.getRequestURI()+"----------");
    		HttpSession session = request.getSession();

    		String uid = (String)session.getAttribute(AuthorizeUtil.KEY_UID);
    		if(uid != null){
				AuthorizeUtil.setSession(session);
    			return super.preHandle(request, response, handler);
    			
    		} else {
				try {

					BaseResponse br = new BaseResponse("-1", "会话超时，请重新登录!");
					writeResult(response, br);

				} catch (IOException e) {
					e.printStackTrace();
				}
				return false;

    		}
    	}

    }

	private void writeResult(HttpServletResponse response, Object data) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
		writer.print(JsonUtils.toJson(data));
		writer.flush();
	}
    
}
