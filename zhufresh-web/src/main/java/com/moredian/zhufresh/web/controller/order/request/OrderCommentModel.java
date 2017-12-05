package com.moredian.zhufresh.web.controller.order.request;

public class OrderCommentModel {

    private Long userId;
    private Long orderId;
    private Integer qualityStar;
    private Integer serviceStar;
    private Integer wholeStar;
    private String commentsDesc;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQualityStar() {
        return qualityStar;
    }

    public void setQualityStar(Integer qualityStar) {
        this.qualityStar = qualityStar;
    }

    public Integer getServiceStar() {
        return serviceStar;
    }

    public void setServiceStar(Integer serviceStar) {
        this.serviceStar = serviceStar;
    }

    public Integer getWholeStar() {
        return wholeStar;
    }

    public void setWholeStar(Integer wholeStar) {
        this.wholeStar = wholeStar;
    }

    public String getCommentsDesc() {
        return commentsDesc;
    }

    public void setCommentsDesc(String commentsDesc) {
        this.commentsDesc = commentsDesc;
    }
}
