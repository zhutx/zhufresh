package com.moredian.zhufresh.enums;

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
public enum ZhufreshErrorCode implements ErrorCode {

	PARAM_WRONG(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "021", "0001"), "参数有误"),

	FAVORITE_CONTAINS_MENU(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "021", "0002"), "该收藏夹下存在菜谱"),

	TICKET_STATUS_FAIL(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "021", "0002"), "菜票状态异常"),

	NOT_YOUR_TICKET(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "021", "0002"), "菜票归属异常"),

	COUPON_CODE_FAIL(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "021", "0002"), "无效优惠码"),

	ORDER_NO_GOODS(new V1ErrorCode(ErrorType.SERVICE, ErrorLevel.WARN, "021", "0002"), "无商品信息"),

	;

	/** 错误码，不能为空 */
	private V1ErrorCode errorCode;

	/** 错误信息，一般情况下不能为空 */
	private String errorMessage;

	ZhufreshErrorCode(V1ErrorCode errorCode, String errorMessage) {
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
