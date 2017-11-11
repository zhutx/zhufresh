package com.moredian.zhufresh.web.controller.menu.request;

import com.moredian.zhufresh.model.MenuBulkInfo;

import java.util.ArrayList;
import java.util.List;

public class MenuBulkConfigModel {

    private Long menuId;
    private List<MenuBulkInfo> bulkInfos = new ArrayList<>();

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public List<MenuBulkInfo> getBulkInfos() {
        return bulkInfos;
    }

    public void setBulkInfos(List<MenuBulkInfo> bulkInfos) {
        this.bulkInfos = bulkInfos;
    }
}
