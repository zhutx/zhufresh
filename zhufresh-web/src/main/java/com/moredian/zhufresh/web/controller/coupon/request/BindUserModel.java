package com.moredian.zhufresh.web.controller.coupon.request;

public class BindUserModel {

    private Long userId;
    private String couponCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}
