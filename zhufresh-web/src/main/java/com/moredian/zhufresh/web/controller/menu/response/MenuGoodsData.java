package com.moredian.zhufresh.web.controller.menu.response;

public class MenuGoodsData {

    private Long menuGoodsId;
    private Long menuId;
    private Long goodsId;
    private Integer weight;
    private Integer sort;

    public Long getMenuGoodsId() {
        return menuGoodsId;
    }

    public void setMenuGoodsId(Long menuGoodsId) {
        this.menuGoodsId = menuGoodsId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
