package com.moredian.zhufresh.request;

import java.io.Serializable;

public class MenuQueryRequest implements Serializable {

    private static final long serialVersionUID = -8290142419594165045L;

    private Integer hotType;
    private Integer styleType;
    private Integer placeType;
    private Integer tasteType;
    private String keywords;
    private Integer status;

    public Integer getHotType() {
        return hotType;
    }

    public void setHotType(Integer hotType) {
        this.hotType = hotType;
    }

    public Integer getStyleType() {
        return styleType;
    }

    public void setStyleType(Integer styleType) {
        this.styleType = styleType;
    }

    public Integer getPlaceType() {
        return placeType;
    }

    public void setPlaceType(Integer placeType) {
        this.placeType = placeType;
    }

    public Integer getTasteType() {
        return tasteType;
    }

    public void setTasteType(Integer tasteType) {
        this.tasteType = tasteType;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
