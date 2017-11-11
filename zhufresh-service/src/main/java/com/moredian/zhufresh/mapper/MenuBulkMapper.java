package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.MenuBulk;
import com.moredian.zhufresh.domain.MenuGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuBulkMapper {

    int insert(MenuBulk menuBulk);

    int updateByGoodsId(@Param("menuId") Long menuId, @Param("relationGoodsId") Long relationGoodsId, @Param("bulkName") String bulkName, @Param("weightText") String weightText);

    int deleteByGoodsId(@Param("menuId") Long menuId, @Param("goodsId") Long goodsId);

    List<Long> findGoodIdsByMenuId(@Param("menuId") Long menuId);

    List<MenuBulk> findByMenuId(@Param("menuId") Long menuId);

}
