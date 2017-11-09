package com.moredian.zhufresh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service")
public class ServiceProperties {
	
	private int deadlineHour;

	public int getDeadlineHour() {
		return deadlineHour;
	}

	public void setDeadlineHour(int deadlineHour) {
		this.deadlineHour = deadlineHour;
	}
}
