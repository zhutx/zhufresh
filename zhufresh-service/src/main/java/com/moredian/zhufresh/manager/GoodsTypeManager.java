package com.moredian.zhufresh.manager;

import com.moredian.zhufresh.domain.GoodsType;

import java.util.List;

public interface GoodsTypeManager {

    Long addGoodsType(String goodsTypeName, Long parentId);

    List<GoodsType> findByParent(Long parentId);
}
