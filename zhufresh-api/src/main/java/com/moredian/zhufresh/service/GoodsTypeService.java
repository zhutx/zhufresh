package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.zhufresh.model.GoodsTypeInfo;

import java.util.List;

public interface GoodsTypeService {

    ServiceResponse<Long> addGoodsType(String goodsTypeName, Long parentId);

    List<GoodsTypeInfo> findByParent(Long parentId);

}
