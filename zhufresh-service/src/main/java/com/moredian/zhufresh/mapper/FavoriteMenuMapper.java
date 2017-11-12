package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.FavoriteMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteMenuMapper {

    List<Long> findMenuId(@Param("userId") Long userId, @Param("favoriteId") Long favoriteId);

    int insert(FavoriteMenu favoriteMenu);

    int deleteOne(@Param("userId") Long userId, @Param("favoriteId") Long favoriteId, @Param("menuId") Long menuId);

    int deleteByMenuId(@Param("userId") Long userId, @Param("menuId") Long menuId);

}
