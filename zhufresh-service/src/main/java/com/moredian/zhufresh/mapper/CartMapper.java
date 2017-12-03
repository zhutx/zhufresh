package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {

    Cart loadByUser(@Param("userId") Long userId);

    int insert(Cart cart);

    int update(Cart cart);

    int delete(@Param("cartId") Long cartId);

}
