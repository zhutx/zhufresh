package com.moredian.zhufresh.model;

import java.io.Serializable;

public class MenuStepInfo implements Serializable {

    private static final long serialVersionUID = -1872253583267036809L;

    private Long menuStepId;
    private Long menuId;
    private Long stepNumber;
    private String stepImgUrl;
    private String stepDesc;

    public Long getMenuStepId() {
        return menuStepId;
    }

    public void setMenuStepId(Long menuStepId) {
        this.menuStepId = menuStepId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Long stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getStepImgUrl() {
        return stepImgUrl;
    }

    public void setStepImgUrl(String stepImgUrl) {
        this.stepImgUrl = stepImgUrl;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }
}
