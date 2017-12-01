package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.OrderGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderGoodsMapper {

    int insert(OrderGoods orderGoods);

}
