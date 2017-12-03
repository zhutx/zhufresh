package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.CartGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartGoodsMapper {

    int insertOrInc(CartGoods cartGoods);

    int deleteAll(@Param("cartId") Long cartId);

    int update(CartGoods cartGoods);

    List<CartGoods> findByCart(@Param("cartId") Long cartId);

}
