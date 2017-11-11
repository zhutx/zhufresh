package com.moredian.zhufresh.web.controller.menu.response;

import com.moredian.zhufresh.web.model.PageData;

import java.util.List;

public class PaginationMenuData extends PageData {

    private List<MenuData> menus;

    public List<MenuData> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuData> menus) {
        this.menus = menus;
    }
}
