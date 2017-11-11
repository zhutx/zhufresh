package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.MenuGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuGoodsMapper {

    int insert(MenuGoods menuGoods);

    int updateByGoodsId(@Param("menuId") Long menuId, @Param("goodsId") Long goodsId, @Param("weight") Integer weight);

    int deleteByGoodsId(@Param("menuId") Long menuId, @Param("goodsId") Long goodsId);

    List<Long> findGoodIdsByMenuId(@Param("menuId") Long menuId);

    List<MenuGoods> findByMenuId(@Param("menuId") Long menuId);

}
