package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Goods;
import com.moredian.zhufresh.domain.GoodsQueryCondition;
import com.moredian.zhufresh.domain.Menu;
import com.moredian.zhufresh.domain.MenuQueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    int insert(Menu menu);

    int update(Menu menu);

    int updateStatus(@Param("menuId") Long menuId, @Param("status") Integer status);

    Menu load(@Param("menuId") Long menuId);

    int getTotalCountByCondition(MenuQueryCondition condition);

    List<Menu> findPaginationByCondition(MenuQueryCondition condition);

    List<Menu> findPaginationByIds(@Param("menuIdList") List<Long> menuIds, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

}
