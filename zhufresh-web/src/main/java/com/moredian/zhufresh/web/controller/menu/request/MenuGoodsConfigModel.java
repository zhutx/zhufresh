package com.moredian.zhufresh.web.controller.menu.request;

import com.moredian.zhufresh.model.MenuGoodsInfo;

import java.util.ArrayList;
import java.util.List;

public class MenuGoodsConfigModel {

    private Long menuId;

    private List<MenuGoodsInfo> goodsInfos = new ArrayList<>();

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public List<MenuGoodsInfo> getGoodsInfos() {
        return goodsInfos;
    }

    public void setGoodsInfos(List<MenuGoodsInfo> goodsInfos) {
        this.goodsInfos = goodsInfos;
    }

}
