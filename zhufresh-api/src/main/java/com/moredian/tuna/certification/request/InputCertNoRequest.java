package com.moredian.tuna.certification.request;

import java.io.Serializable;

public class InputCertNoRequest implements Serializable {
	
	private static final long serialVersionUID = -5678187090479330483L;
	
	private String deviceSn;
	/** 抓拍照 */
	private byte[] catchImage;
	/** 身份证号 */
	private String certNo;
	
	public String getDeviceSn() {
		return deviceSn;
	}
	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	public byte[] getCatchImage() {
		return catchImage;
	}
	public void setCatchImage(byte[] catchImage) {
		this.catchImage = catchImage;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

}
