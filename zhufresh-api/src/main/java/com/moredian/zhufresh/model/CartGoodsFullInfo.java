package com.moredian.zhufresh.model;

public class CartGoodsFullInfo extends CartGoodsInfo {

    private static final long serialVersionUID = 7843853956927254156L;

    private Integer unit;
    private Integer unitPrice;

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }
}
