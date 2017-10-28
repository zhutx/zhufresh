package com.moredian.tuna.certification.response;

import java.io.Serializable;

public class OverviewInfo implements Serializable {
	
	private static final long serialVersionUID = 8389920881337364359L;
	
	private Integer alarmTimes;
	private Integer authTimes;
	private Integer devices;
	
	public Integer getAlarmTimes() {
		return alarmTimes;
	}
	public void setAlarmTimes(Integer alarmTimes) {
		this.alarmTimes = alarmTimes;
	}
	public Integer getAuthTimes() {
		return authTimes;
	}
	public void setAuthTimes(Integer authTimes) {
		this.authTimes = authTimes;
	}
	public Integer getDevices() {
		return devices;
	}
	public void setDevices(Integer devices) {
		this.devices = devices;
	}

}
