package com.moredian.tuna.certification.web.controller.overview;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.fishnet.org.enums.OrgType;
import com.moredian.fishnet.org.enums.YesNoFlag;
import com.moredian.tuna.certification.model.AuthDistInfo;
import com.moredian.tuna.certification.model.DeviceDistInfo;
import com.moredian.tuna.certification.model.SessionUser;
import com.moredian.tuna.certification.response.DeviceOnlineInfo;
import com.moredian.tuna.certification.response.OverviewInfo;
import com.moredian.tuna.certification.service.OverviewService;
import com.moredian.tuna.certification.web.controller.BaseController;
import com.moredian.tuna.certification.web.controller.overview.response.AuthTimesData;
import com.moredian.tuna.certification.web.controller.overview.response.AuthTimesStateData;
import com.moredian.tuna.certification.web.controller.overview.response.DeviceInstallsData;
import com.moredian.tuna.certification.web.controller.overview.response.DeviceOnlineData;
import com.moredian.tuna.certification.web.controller.overview.response.OverviewData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Overview API", description = "数据总览接口")
@RequestMapping("/overview")
public class OverviewController extends BaseController {
	
	@SI
	private OverviewService overviewService;
	
	@ApiOperation(value="获取统计数据", notes="获取统计数据")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/data", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse data(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizAreaCode")Integer bizAreaCode, HttpServletRequest request) {
		
		BaseResponse<OverviewData> bdr = new BaseResponse<>();
		
		OverviewInfo info = overviewService.getData(bizAreaCode);
		
		bdr.setData(BeanUtils.copyProperties(OverviewData.class, info));
		
		return bdr;
    }
	
	private AuthTimesData buildAuthTimesData(List<AuthDistInfo> authDistInfoList) {
		if(CollectionUtils.isEmpty(authDistInfoList)) return null;
		AuthTimesData data = new AuthTimesData();
		for(AuthDistInfo authDistInfo : authDistInfoList) {
			if(OrgType.HOTEL.getValue() == authDistInfo.getOrgType()) data.setHotelTimes(authDistInfo.getAuthTimes());
			if(OrgType.NETBAR.getValue() == authDistInfo.getOrgType()) data.setBarTimes(authDistInfo.getAuthTimes());
		}
		return data;
	}
	
	@ApiOperation(value="获取认证次数统计数据", notes="获取认证次数统计数据")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/authTimes", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse authTimes(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizAreaCode")Integer bizAreaCode, HttpServletRequest request) {
		
		BaseResponse<AuthTimesData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		List<AuthDistInfo> authDistInfoList = overviewService.findAuthDist(bizAreaCode);
		
		bdr.setData(this.buildAuthTimesData(authDistInfoList));
		
		return bdr;
    }
	
	private DeviceInstallsData buildDeviceInstallsData(List<DeviceDistInfo> deviceDistInfoList) {
		if(CollectionUtils.isEmpty(deviceDistInfoList)) return null;
		DeviceInstallsData data = new DeviceInstallsData();
		for(DeviceDistInfo deviceDistInfo : deviceDistInfoList) {
			if(OrgType.HOTEL.getValue() == deviceDistInfo.getOrgType()) data.setHotelInstalls(deviceDistInfo.getInstalls());
			if(OrgType.NETBAR.getValue() == deviceDistInfo.getOrgType()) data.setBarInstalls(deviceDistInfo.getInstalls());
		}
		return data;
	}
	
	@ApiOperation(value="获取设备安装统计数据", notes="获取设备安装统计数据")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/installs", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse installs(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizAreaCode")Integer bizAreaCode, HttpServletRequest request) {
		
		BaseResponse<DeviceInstallsData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		List<DeviceDistInfo> deviceDistInfoList = overviewService.findDeviceDist(bizAreaCode);
		
		bdr.setData(this.buildDeviceInstallsData(deviceDistInfoList));
		
		return bdr;
    }
	
	private AuthTimesStateData buildAuthTimesStateData(List<AuthDistInfo> authDistInfoList) {
		if(CollectionUtils.isEmpty(authDistInfoList)) return null;
		AuthTimesStateData data = new AuthTimesStateData();
		for(AuthDistInfo authDistInfo : authDistInfoList) {
			if(OrgType.HOTEL.getValue() == authDistInfo.getOrgType()) {
				data.setHotelAuthTimes(authDistInfo.getAuthTimes());
				data.setHotelFailTimes(authDistInfo.getFailTimes());
			}
			if(OrgType.NETBAR.getValue() == authDistInfo.getOrgType()) {
				data.setBarAuthTimes(authDistInfo.getAuthTimes());
				data.setBarFailTimes(authDistInfo.getFailTimes());
			}
		}
		return data;
	}
	
	@ApiOperation(value="获取认证通过率", notes="获取设备安装统计数据")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/authPass", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse authPass(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizAreaCode")Integer bizAreaCode, HttpServletRequest request) {
		
		BaseResponse<AuthTimesStateData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		List<AuthDistInfo> authDistInfoList = overviewService.findAuthDist(bizAreaCode);
		
		bdr.setData(this.buildAuthTimesStateData(authDistInfoList));
		
		return bdr;
    }
	
	private DeviceOnlineData buildDeviceOnlineData(List<DeviceOnlineInfo> deviceOnlieInfoList) {
		if(CollectionUtils.isEmpty(deviceOnlieInfoList)) return null;
		DeviceOnlineData data = new DeviceOnlineData();
		int hotelInstalls = 0;
		int hotelOnlines = 0;
		int barInstalls = 0;
		int barOnlines = 0;
		for(DeviceOnlineInfo deviceOnlineInfo : deviceOnlieInfoList) {
			if(OrgType.HOTEL.getValue() == deviceOnlineInfo.getOrgType()) {
				hotelInstalls += 1;
				if(YesNoFlag.YES.getValue() == deviceOnlineInfo.getOnlineFlag()) {
					hotelOnlines += 1;
				}
			}
			if(OrgType.NETBAR.getValue() == deviceOnlineInfo.getOrgType()) {
				barInstalls += 1;
				if(YesNoFlag.YES.getValue() == deviceOnlineInfo.getOnlineFlag()) {
					barOnlines += 1;
				}
			}
		}
		data.setHotelInstalls(hotelInstalls);
		data.setHotelOnlines(hotelOnlines);
		data.setBarInstalls(barInstalls);
		data.setBarOnlines(barOnlines);
		return data;
	}
	
	@ApiOperation(value="获取设备在线率", notes="获取设备在线率")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/deviceOnline", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse deviceOnline(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizAreaCode")Integer bizAreaCode, HttpServletRequest request) {
		
		BaseResponse<DeviceOnlineData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		List<DeviceOnlineInfo> deviceOnlieInfoList = overviewService.findDeviceOnlineFlag(bizAreaCode);
		
		bdr.setData(this.buildDeviceOnlineData(deviceOnlieInfoList));
		
		return bdr;
    }

}
