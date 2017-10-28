package com.moredian.tuna.certification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("auth")
public class AuthProperties {
	
	private float threshold;
	private String alarmWebUrl;

	public float getThreshold() {
		return threshold;
	}

	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}

	public String getAlarmWebUrl() {
		return alarmWebUrl;
	}

	public void setAlarmWebUrl(String alarmWebUrl) {
		this.alarmWebUrl = alarmWebUrl;
	}

	
}
