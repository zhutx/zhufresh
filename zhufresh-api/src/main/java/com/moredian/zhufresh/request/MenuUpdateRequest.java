package com.moredian.zhufresh.request;

import java.io.Serializable;

public class MenuUpdateRequest implements Serializable {

    private static final long serialVersionUID = -5504372867369294772L;

    private Long menuId;
    private String menuName;
    private Integer hotType;
    private Integer styleType;
    private Integer placeType;
    private Integer tasteType;
    private String menuImgUrl;
    private Integer cookieWay;
    private Integer cookieTime;
    private String keywords;
    private String menuDesc;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

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

    public String getMenuImgUrl() {
        return menuImgUrl;
    }

    public void setMenuImgUrl(String menuImgUrl) {
        this.menuImgUrl = menuImgUrl;
    }

    public Integer getCookieWay() {
        return cookieWay;
    }

    public void setCookieWay(Integer cookieWay) {
        this.cookieWay = cookieWay;
    }

    public Integer getCookieTime() {
        return cookieTime;
    }

    public void setCookieTime(Integer cookieTime) {
        this.cookieTime = cookieTime;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }
}
