package com.moredian.zhufresh.web.controller.menu.request;

import com.moredian.zhufresh.model.MenuStepInfo;

import java.util.ArrayList;
import java.util.List;

public class MenuStepConfigModel {

    private Long menuId;
    private List<MenuStepInfo> stepInfos = new ArrayList<>();

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public List<MenuStepInfo> getStepInfos() {
        return stepInfos;
    }

    public void setStepInfos(List<MenuStepInfo> stepInfos) {
        this.stepInfos = stepInfos;
    }
}
