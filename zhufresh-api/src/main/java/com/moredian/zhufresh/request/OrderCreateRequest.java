package com.moredian.zhufresh.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderCreateRequest implements Serializable {

    private static final long serialVersionUID = 5302943358207448823L;

    private Integer orderType;
    private String ticketCode;
    private String couponCode;
    private String orderMessage;
    private Long userId;
    private Long addressId;
    private Date receiveExpectTime;

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

    public Date getReceiveExpectTime() {
        return receiveExpectTime;
    }

    public void setReceiveExpectTime(Date receiveExpectTime) {
        this.receiveExpectTime = receiveExpectTime;
    }

    public List<OrderGoodsRequest> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoodsRequest> goods) {
        this.goods = goods;
    }
}
