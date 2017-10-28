package com.moredian.tuna.certification.web.controller.tendency;

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
import com.moredian.tuna.certification.web.controller.tendency.response.DayAuthPresentData;
import com.moredian.tuna.certification.web.controller.tendency.response.DayAuthTimesData;
import com.moredian.tuna.certification.web.controller.tendency.response.DeviceInstallPresentData;
import com.moredian.tuna.certification.web.controller.tendency.response.HourAuthCompareData;
import com.moredian.tuna.certification.web.controller.tendency.response.HourAuthPresentCompareData;
import com.moredian.tuna.certification.web.controller.tendency.response.TodayData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Tendency API", description = "趋势统计接口")
@RequestMapping("/tendency")
public class TendencyController extends BaseController {
	
	@ApiOperation(value="获取今日统计数据", notes="获取今日统计数据")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/today", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse today(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, HttpServletRequest request) {
		
		BaseResponse<TodayData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="获取认证次数图标数据（按小时对比两日）", notes="获取认证次数图标数据（按小时对比两日）")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/timesByHour", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse timesByHour(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "oneDate") String oneDate, @RequestParam(value = "otherDate") String otherDate, @RequestParam(value = "orgType", required = false) Integer orgType, HttpServletRequest request) {
		
		BaseResponse<HourAuthCompareData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="获取认证次数图标数据（按日）", notes="获取认证次数图标数据（按日）")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/timesByDay", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse timesByDay(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "beginDate") String beginDate, @RequestParam(value = "endDate") String endDate, @RequestParam(value = "orgType", required = false) Integer orgType, HttpServletRequest request) {
		
		BaseResponse<List<DayAuthTimesData>> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="获取异常次数图标数据（按小时对比两日）", notes="获取异常次数图标数据（按小时对比两日）")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/failTimesByHour", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse failTimesByHour(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "oneDate") String oneDate, @RequestParam(value = "otherDate") String otherDate, @RequestParam(value = "orgType", required = false) Integer orgType, HttpServletRequest request) {
		
		BaseResponse<HourAuthCompareData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="获取异常次数图标数据（按日）", notes="获取异常次数图标数据（按日）")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/failTimesByDay", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse failTimesByDay(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "beginDate") String beginDate, @RequestParam(value = "endDate") String endDate, @RequestParam(value = "orgType", required = false) Integer orgType, HttpServletRequest request) {
		
		BaseResponse<List<DayAuthTimesData>> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="获取通过率图表数据（按小时对比两日）", notes="获取通过率图表数据（按小时对比两日）")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/authPassForHours", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse authPassForHours(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "oneDate") String oneDate, @RequestParam(value = "otherDate") String otherDate, @RequestParam(value = "orgType", required = false) Integer orgType, HttpServletRequest request) {
		
		BaseResponse<HourAuthPresentCompareData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="获取通过率图表数据（按日）", notes="获取通过率图表数据（按日）")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/authPassForDays", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse authPassForDays(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "beginDate") String beginDate, @RequestParam(value = "endDate") String endDate, @RequestParam(value = "orgType", required = false) Integer orgType, HttpServletRequest request) {
		
		BaseResponse<List<DayAuthPresentData>> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }
	
	@ApiOperation(value="获取辖区设备安装占比", notes="获取辖区设备安装占比")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/installPresent", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse installPresent(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "orgType") Integer orgType, HttpServletRequest request) {
		
		BaseResponse<List<DeviceInstallPresentData>> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		
		bdr.setData(null);
		
		return bdr;
    }

}
