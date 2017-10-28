package com.moredian.tuna.certification.manager.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moredian.tuna.certification.domain.AuthDist;
import com.moredian.tuna.certification.domain.DeviceDist;
import com.moredian.tuna.certification.manager.OverviewManager;
import com.moredian.tuna.certification.mapper.AuthDistMapper;
import com.moredian.tuna.certification.mapper.DeviceDistMapper;
import com.moredian.tuna.certification.response.OverviewInfo;

@Service
public class OverviewManagerImpl implements OverviewManager {
	
	@Autowired
	private AuthDistMapper authDistMapper;
	@Autowired
	private DeviceDistMapper deviceDistMapper;
	
	private int fetchAuthTimes(List<AuthDist> authDistList) {
		int result = 0;
		if(CollectionUtils.isEmpty(authDistList)) return result;
		for(AuthDist authDist : authDistList) {
			result += authDist.getAuthTimes();
		}
		return result;
	}
	
	private int fetchAlarmTimes(List<AuthDist> authDistList) {
		int result = 0;
		if(CollectionUtils.isEmpty(authDistList)) return result;
		for(AuthDist authDist : authDistList) {
			result += authDist.getAlarmTimes();
		}
		return result;
	}
	
	private int fetchDeviceInstalls(List<DeviceDist> deviceDistList) {
		int result = 0;
		if(CollectionUtils.isEmpty(deviceDistList)) return result;
		for(DeviceDist deviceDist : deviceDistList) {
			result += deviceDist.getInstalls();
		}
		return result;
	}
	
	@Override
	public OverviewInfo getData(Integer areaCode) {
		
		List<AuthDist> authDistList = authDistMapper.findByAreaCode(areaCode);
		List<DeviceDist> deviceDistList = deviceDistMapper.findByAreaCode(areaCode);
		
		OverviewInfo overviewInfo = new OverviewInfo();
		overviewInfo.setAuthTimes(this.fetchAuthTimes(authDistList));
		overviewInfo.setAlarmTimes(this.fetchAlarmTimes(authDistList));
		overviewInfo.setDevices(this.fetchDeviceInstalls(deviceDistList));
		
		return overviewInfo;
	}

	@Override
	public List<AuthDist> findAuthDist(Integer areaCode) {
		return authDistMapper.findByAreaCode(areaCode);
	}

	@Override
	public List<DeviceDist> findDeviceDist(Integer areaCode) {
		return deviceDistMapper.findByAreaCode(areaCode);
	}

}
