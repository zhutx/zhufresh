package com.moredian.tuna.certification.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.fishnet.device.service.CertificationDeviceService;
import com.moredian.fishnet.org.model.AreaInfo;
import com.moredian.fishnet.org.service.AreaService;
import com.moredian.tuna.certification.domain.AuthDist;
import com.moredian.tuna.certification.domain.DeviceDist;
import com.moredian.tuna.certification.manager.OverviewManager;
import com.moredian.tuna.certification.model.AuthDistInfo;
import com.moredian.tuna.certification.model.DeviceDistInfo;
import com.moredian.tuna.certification.response.DeviceOnlineInfo;
import com.moredian.tuna.certification.response.OverviewInfo;
import com.moredian.tuna.certification.service.OverviewService;

@SI
public class OverviewServiceImpl implements OverviewService {
	
	@Autowired
	private OverviewManager overviewManager;
	
	@SI
	private CertificationDeviceService certificationDeviceService;
	@SI
	private AreaService areaService;

	@Override
	public OverviewInfo getData(Integer areaCode) {
		return overviewManager.getData(areaCode);
	}

	@Override
	public List<AuthDistInfo> findAuthDist(Integer areaCode) {
		List<AuthDist> authDistList = overviewManager.findAuthDist(areaCode);
		return BeanUtils.copyListProperties(AuthDistInfo.class, authDistList);
	}

	@Override
	public List<DeviceDistInfo> findDeviceDist(Integer areaCode) {
		List<DeviceDist> deviceDistList = overviewManager.findDeviceDist(areaCode);
		return BeanUtils.copyListProperties(DeviceDistInfo.class, deviceDistList);
	}

	@Override
	public List<DeviceOnlineInfo> findDeviceOnlineFlag(Integer areaCode) {
		
		AreaInfo area = areaService.getAreaByCode(areaCode);
		
		Integer provCode = null;
		Integer cityCode = null;
		Integer districtCode = null;
		Integer townCode = null;
		if(area.getAreaLevel() == 1) {
			provCode = areaCode;
		}
		if(area.getAreaLevel() == 2) {
			cityCode = areaCode;
		}
		if(area.getAreaLevel() == 3) {
			districtCode = areaCode;
		}
		if(area.getAreaLevel() == 4) {
			townCode = areaCode;
		}
		
		//List<com.moredian.fishnet.device.response.DeviceOnlineInfo> deviceOnlineInfoList = certificationDeviceService.findOnlineData(provCode, cityCode, districtCode, townCode);
		return BeanUtils.copyListProperties(DeviceOnlineInfo.class, null);
	}

}
