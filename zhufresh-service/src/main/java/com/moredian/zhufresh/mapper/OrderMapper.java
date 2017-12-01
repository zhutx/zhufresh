package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int insert(Order order);

}
