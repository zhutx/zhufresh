package com.moredian.tuna.certification.manager;

import java.util.List;

import com.moredian.tuna.certification.domain.AuthDist;
import com.moredian.tuna.certification.domain.DeviceDist;
import com.moredian.tuna.certification.response.OverviewInfo;

public interface OverviewManager {
	
	 OverviewInfo getData(Integer areaCode);
	 
	 List<AuthDist> findAuthDist(Integer areaCode);
	 
	 List<DeviceDist> findDeviceDist(Integer areaCode);

}
