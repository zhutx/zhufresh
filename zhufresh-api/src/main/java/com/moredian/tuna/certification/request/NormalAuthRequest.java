package com.moredian.tuna.certification.request;

import java.io.Serializable;

public class NormalAuthRequest implements Serializable {
	
	private static final long serialVersionUID = -5678187090479330483L;
	
	private String deviceSn;
	/** 抓拍照 */
	private byte[] catchImage;
	/** 芯片照 */
	private byte[] certImage;
	/** 身份证信息 */
	private String certInfo;
	
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

}
