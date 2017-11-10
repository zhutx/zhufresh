package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsTypeMapper {

    int insert(GoodsType goodsType);

    List<GoodsType> findByParent(Long parentId);

}
