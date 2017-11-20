package com.moredian.zhufresh.web.controller.coupon.response;

import com.moredian.zhufresh.web.model.PageData;

import java.util.List;

public class PaginationCouponData extends PageData {

    private List<CouponData> coupons;

    public List<CouponData> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponData> coupons) {
        this.coupons = coupons;
    }
}
