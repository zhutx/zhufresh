package com.moredian.zhufresh.web.controller.coupon.request;

public class CouponBatchCreateModel {

    private Integer couponPrice;
    private Integer amount;

    public Integer getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Integer couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
