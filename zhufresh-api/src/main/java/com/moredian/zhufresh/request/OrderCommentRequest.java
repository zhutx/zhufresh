package com.moredian.zhufresh.request;

import java.io.Serializable;

public class OrderCommentRequest implements Serializable {

    private static final long serialVersionUID = -710791084528413379L;

    private Long userId;
    private Long orderId;
    private Integer qualityStar;
    private Integer serviceStar;
    private Integer wholeStar;
    private String comments_desc;

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

    public String getComments_desc() {
        return comments_desc;
    }

    public void setComments_desc(String comments_desc) {
        this.comments_desc = comments_desc;
    }
}
