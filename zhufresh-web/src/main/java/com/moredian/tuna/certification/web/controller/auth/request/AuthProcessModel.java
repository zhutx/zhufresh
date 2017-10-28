package com.moredian.tuna.certification.web.controller.auth.request;

public class AuthProcessModel {
	
	/** 设备SN */
	private String deviceSn;
	/** 抓拍照 */
	private byte[] catchImage;
	/** 芯片照 */
	private byte[] certImage;
	/** 身份证信息 */
	private String certInfo;
	/** 手输身份证号 */
	private String inputCertNo;
	
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
	public byte[] getCertImage() {
		return certImage;
	}
	public void setCertImage(byte[] certImage) {
		this.certImage = certImage;
	}
	public String getCertInfo() {
		return certInfo;
	}
	public void setCertInfo(String certInfo) {
		this.certInfo = certInfo;
	}
	public String getInputCertNo() {
		return inputCertNo;
	}
	public void setInputCertNo(String inputCertNo) {
		this.inputCertNo = inputCertNo;
	}

}
