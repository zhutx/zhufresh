package com.moredian.tuna.certification.enums;

import com.moredian.bee.common.exception.ErrorCode;
import com.moredian.bee.common.exception.v1.ErrorLevel;
import com.moredian.bee.common.exception.v1.ErrorType;
import com.moredian.bee.common.exception.v1.V1ErrorCode;

/**
 * 定义机构错误码类型
 *
 * @author zhutx
 *
 */
public enum CertificationErrorCode implements ErrorCode {
	
	PARAM_WRONG(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "014", "0001"), "参数有误"),
	
	SAVE_IMAGE_ERROR(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "014", "0002"), "存储图片异常"),
	
	SAVE_IMAGE_WRONG(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "014", "0003"), "存储图片失败"),

	;

	/** 错误码，不能为空 */
	private V1ErrorCode errorCode;

	/** 错误信息，一般情况下不能为空 */
	private String errorMessage;

	CertificationErrorCode(V1ErrorCode errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	@Override
	public String getCode() {
		return this.errorCode.getCode();
	}

	/**
	 * @return the errorMessage
	 */
	public String getMessage() {
		return errorMessage;
	}

}
