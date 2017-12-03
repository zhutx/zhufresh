package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.CartGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartGoodsMapper {

    int insertOrInc(CartGoods cartGoods);

}
