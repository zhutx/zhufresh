package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.Goods;
import com.moredian.zhufresh.domain.GoodsType;
import com.moredian.zhufresh.manager.GoodsTypeManager;
import com.moredian.zhufresh.mapper.GoodsTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeManagerImpl implements GoodsTypeManager {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private GoodsType buildGoodsType(String goodsTypeName, Long parentId) {
        GoodsType goodsType = new GoodsType();
        goodsType.setGoodsTypeId(genPrimaryKey(GoodsType.class.getName()));
        goodsType.setGoodsTypeName(goodsTypeName);
        goodsType.setParentId(parentId);
        return goodsType;
    }

    @Override
    public Long addGoodsType(String goodsTypeName, Long parentId) {
        BizAssert.notBlank(goodsTypeName, "goodsTypeName is required");
        BizAssert.notNull(parentId, "parentId is required");
        GoodsType goodsType = this.buildGoodsType(goodsTypeName, parentId);
        goodsTypeMapper.insert(goodsType);
        return goodsType.getGoodsTypeId();
    }

    @Override
    public List<GoodsType> findByParent(Long parentId) {
        BizAssert.notNull(parentId, "parentId is required");
        return goodsTypeMapper.findByParent(parentId);
    }
}
