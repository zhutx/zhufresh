package com.moredian.zhufresh.web.controller.goods.response;

import com.moredian.zhufresh.web.model.PageData;

import java.util.List;

public class PaginationGoodsData extends PageData {

    private List<GoodsData> goodsList;

    public List<GoodsData> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsData> goodsList) {
        this.goodsList = goodsList;
    }
}
