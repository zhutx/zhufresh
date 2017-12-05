package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Comments;
import com.moredian.zhufresh.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    int insert(Order order);

    int updateByPay(@Param("orderCode") String orderCode, @Param("payWay") Integer payWay, @Param("payCert") String payCert, @Param("status") Integer status);

    int updateByDispatch(@Param("orderId") Long orderId, @Param("deliveryOperId") Long deliveryOperId, @Param("deliveryOperName") String deliveryOperName, @Param("deliveryMobile") String deliveryMobile);

    int updateByDeliver(@Param("orderId") Long orderId, @Param("oldStatus") Integer oldStatus, @Param("newStatus") Integer newStatus);

    int updateByArrival(@Param("orderId") Long orderId, @Param("userId") Long userId, @Param("deliveryOperId") Long operId, @Param("oldStatus") Integer oldStatus, @Param("newStatus") Integer newStatus);

    int updateByComment(Comments comments);

}
