package com.moredian.zhufresh.web.controller.order.request;

import com.moredian.zhufresh.request.OrderGoodsRequest;

import java.util.List;

public class OrderCreateModel {

    private Integer orderType;
    private String ticketCode;
    private String couponCode;
    private String orderMessage;
    private Long userId;
    private Long addressId;
    private String receiveExpectTime;

    private List<OrderGoodsRequest> goods;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getReceiveExpectTime() {
        return receiveExpectTime;
    }

    public void setReceiveExpectTime(String receiveExpectTime) {
        this.receiveExpectTime = receiveExpectTime;
    }

    public List<OrderGoodsRequest> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoodsRequest> goods) {
        this.goods = goods;
    }
}
