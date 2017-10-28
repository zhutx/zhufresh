package com.moredian.tuna.certification.web.controller.zone;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moredian.bee.common.web.BaseResponse;
import com.moredian.tuna.certification.model.SessionUser;
import com.moredian.tuna.certification.web.controller.BaseController;
import com.moredian.tuna.certification.web.controller.zone.response.AreaAuthCollData;
import com.moredian.tuna.certification.web.controller.zone.response.AreaAuthDistData;
import com.moredian.tuna.certification.web.controller.zone.response.AreaDeviceDistData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Zone API", description = "辖区管理接口")
@RequestMapping("/zone")
public class ZoneController extends BaseController {
	
	@ApiOperation(value="获取辖区认证分布", notes="获取辖区认证分布")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/authDist", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse authDist(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, HttpServletRequest request) {
		
		BaseResponse<AreaAuthDistData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="获取设备分布", notes="获取设备分布")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/deviceDist", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse deviceDist(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, HttpServletRequest request) {
		
		BaseResponse<AreaDeviceDistData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="查询辖区认证汇总数据", notes="查询辖区认证汇总数据")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/listColl", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse listColl(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, HttpServletRequest request) {
		
		BaseResponse<List<AreaAuthCollData>> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	

}
