package com.moredian.tuna.certification.web.controller.overview.response;

public class AuthTimesStateData {
	
	private Integer hotelAuthTimes;
	private Integer hotelFailTimes;
	private Integer barAuthTimes;
	private Integer barFailTimes;
	
	public Integer getHotelAuthTimes() {
		return hotelAuthTimes;
	}
	public void setHotelAuthTimes(Integer hotelAuthTimes) {
		this.hotelAuthTimes = hotelAuthTimes;
	}
	public Integer getHotelFailTimes() {
		return hotelFailTimes;
	}
	public void setHotelFailTimes(Integer hotelFailTimes) {
		this.hotelFailTimes = hotelFailTimes;
	}
	public Integer getBarAuthTimes() {
		return barAuthTimes;
	}
	public void setBarAuthTimes(Integer barAuthTimes) {
		this.barAuthTimes = barAuthTimes;
	}
	public Integer getBarFailTimes() {
		return barFailTimes;
	}
	public void setBarFailTimes(Integer barFailTimes) {
		this.barFailTimes = barFailTimes;
	}

}
