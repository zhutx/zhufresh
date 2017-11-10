package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.GoodsType;
import com.moredian.zhufresh.manager.GoodsTypeManager;
import com.moredian.zhufresh.model.GoodsTypeInfo;
import com.moredian.zhufresh.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SI
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeManager goodsTypeManager;

    @Override
    public ServiceResponse<Long> createGoodsType(String goodsTypeName, Long parentId) {
        Long result = goodsTypeManager.addGoodsType(goodsTypeName, parentId);
        return new ServiceResponse<Long>(true, null, result);
    }

    private List<GoodsTypeInfo> goodsTypesToGoodsTypeInfos(List<GoodsType> goodsTypes) {
        return BeanUtils.copyListProperties(GoodsTypeInfo.class, goodsTypes);
    }

    @Override
    public List<GoodsTypeInfo> findByParent(Long parentId) {
        List<GoodsType> goodsTypes = goodsTypeManager.findByParent(parentId);
        return goodsTypesToGoodsTypeInfos(goodsTypes);
    }
}
