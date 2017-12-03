package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.BuildingGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BuildingGoodsMapper {

    List<Long> findGoodsIdByBuilding(@Param("buildingId") Long buildingId);

    int insert(BuildingGoods buildingGoods);

    int deleteOne(@Param("buildingId") Long buildingId, @Param("goodsId") Long goodsId);

}
