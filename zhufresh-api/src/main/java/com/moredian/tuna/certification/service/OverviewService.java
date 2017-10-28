package com.moredian.tuna.certification.service;

import java.util.List;

import com.moredian.tuna.certification.model.AuthDistInfo;
import com.moredian.tuna.certification.model.DeviceDistInfo;
import com.moredian.tuna.certification.response.DeviceOnlineInfo;
import com.moredian.tuna.certification.response.OverviewInfo;

public interface OverviewService {
	
	OverviewInfo getData(Integer areaCode);
	
	List<AuthDistInfo> findAuthDist(Integer areaCode);
	
	List<DeviceDistInfo> findDeviceDist(Integer areaCode);
	
	List<DeviceOnlineInfo> findDeviceOnlineFlag(Integer areaCode);

}
