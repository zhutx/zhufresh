package com.moredian.zhufresh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service")
public class ServiceProperties {
	
	private int deadlineHour;
	private int orderServicePrice;
	private int noServicePrice;

	public int getDeadlineHour() {
		return deadlineHour;
	}

	public void setDeadlineHour(int deadlineHour) {
		this.deadlineHour = deadlineHour;
	}

	public int getOrderServicePrice() {
		return orderServicePrice;
	}

	public void setOrderServicePrice(int orderServicePrice) {
		this.orderServicePrice = orderServicePrice;
	}

	public int getNoServicePrice() {
		return noServicePrice;
	}

	public void setNoServicePrice(int noServicePrice) {
		this.noServicePrice = noServicePrice;
	}
}
