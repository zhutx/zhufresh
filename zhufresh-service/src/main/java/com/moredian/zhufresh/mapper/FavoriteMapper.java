package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteMapper {

    int insert(Favorite favorite);

    int update(Favorite favorite);

    int delete(@Param("userId") Long userId, @Param("favoriteId") Long favoriteId);

    List<Favorite> findByUserId(@Param("userId") Long userId);

}
