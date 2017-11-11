package com.moredian.zhufresh.web.controller.menu.response;

public class MenuBulkData {

    private Long menuBulkId;
    private Long menuId;
    private String bulkName;
    private String weightText;
    private Long relationGoodsId;
    private Integer sort;

    public Long getMenuBulkId() {
        return menuBulkId;
    }

    public void setMenuBulkId(Long menuBulkId) {
        this.menuBulkId = menuBulkId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getBulkName() {
        return bulkName;
    }

    public void setBulkName(String bulkName) {
        this.bulkName = bulkName;
    }

    public String getWeightText() {
        return weightText;
    }

    public void setWeightText(String weightText) {
        this.weightText = weightText;
    }

    public Long getRelationGoodsId() {
        return relationGoodsId;
    }

    public void setRelationGoodsId(Long relationGoodsId) {
        this.relationGoodsId = relationGoodsId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
