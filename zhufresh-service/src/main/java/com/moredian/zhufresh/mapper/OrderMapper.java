package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    int insert(Order order);

    int updateByPay(@Param("orderCode") String orderCode, @Param("payWay") Integer payWay, @Param("payCert") String payCert, @Param("status") Integer status);

}
