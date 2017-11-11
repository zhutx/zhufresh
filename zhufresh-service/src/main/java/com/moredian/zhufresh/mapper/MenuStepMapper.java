package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.MenuStep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuStepMapper {

    int deleteByMenuId(@Param("menuId") Long menuId);

    int insert(MenuStep menuStep);

    List<MenuStep> findByMenuId(@Param("menuId") Long menuId);

}
