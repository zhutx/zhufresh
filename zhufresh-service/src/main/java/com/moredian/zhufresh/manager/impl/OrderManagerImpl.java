package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.ExceptionUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.config.ServiceProperties;
import com.moredian.zhufresh.domain.*;
import com.moredian.zhufresh.enums.OrderStatus;
import com.moredian.zhufresh.enums.ZhufreshErrorCode;
import com.moredian.zhufresh.manager.*;
import com.moredian.zhufresh.mapper.AddressMapper;
import com.moredian.zhufresh.mapper.OrderGoodsMapper;
import com.moredian.zhufresh.mapper.OrderMapper;
import com.moredian.zhufresh.request.OrderCreateRequest;
import com.moredian.zhufresh.request.OrderGoodsRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderManagerImpl implements OrderManager {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    private GoodsManager goodsManager;
    @Autowired
    private ServiceProperties serviceProperties;
    @Autowired
    private AddressManager addressManager;
    @Autowired
    private BuildingManager buildingManager;
    @Autowired
    private TicketManager ticketManager;
    @Autowired
    private CouponManager couponManager;
    @SI
    private IdgeneratorService idgeneratorService;



    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private int getOrderServicePrice(int orderGoodsPrice) {
        if (orderGoodsPrice >= serviceProperties.getNoServicePrice()) return 0;
        return serviceProperties.getOrderServicePrice();
    }

    private Address getReceiveAddress(Long userId, Long addressId) {
        return addressManager.getAddress(userId, addressId);
    }

    private Building getReceiveBuilding(Long buildingId) {
        return buildingManager.getBuilding(buildingId);
    }

    private void fillOrderGoodsInfo(Order order, List<OrderGoods> orderGoodsList) {

        int orderGoodsPrice = 0;
        int orderGoodsSize = 0;
        for (OrderGoods orderGoods : orderGoodsList) {
            orderGoods.setOrderId(order.getOrderId());
            orderGoodsPrice += orderGoods.getPrice();
            orderGoodsSize++;
        }

        order.setOrderGoodsPrice(orderGoodsPrice);
        order.setOrderGoodsSize(orderGoodsSize);

    }

    private int getPayPrice(Order order) {
        return order.getOrderGoodsPrice() + order.getOrderServicePrice() - order.getTicketPrice() - order.getCouponPrice();
    }

    private Order requestToDomain(OrderCreateRequest request, List<OrderGoods> orderGoodsList) {
        Order order = new Order();
        order.setOrderId(genPrimaryKey(Order.class.getName()));
        order.setOrderCode(RandomStringUtils.randomNumeric(15)); // 换成zookeeper获取 TODO
        order.setOrderType(request.getOrderType());
        this.fillOrderGoodsInfo(order, orderGoodsList);
        order.setOrderServicePrice(this.getOrderServicePrice(order.getOrderGoodsPrice()));
        order.setTicketPrice(0);
        if (StringUtils.isNotBlank(request.getTicketCode())) {
            Ticket ticket = ticketManager.getTicketByCode(request.getUserId(), request.getTicketCode());
            order.setTicketCode(request.getTicketCode());
            order.setTicketPrice(ticket.getTicketPrice());
        }
        order.setCouponPrice(0);
        if (StringUtils.isNotBlank(request.getCouponCode())) {
            Coupon coupon = couponManager.getCouponByCode(request.getUserId(), request.getCouponCode());
            order.setCouponCode(request.getCouponCode());
            order.setCouponPrice(coupon.getCouponPrice());
        }
        order.setPayPrice(getPayPrice(order));
        order.setOrderMessage(request.getOrderMessage());
        order.setReceiveUserId(request.getUserId());
        Address address = this.getReceiveAddress(request.getUserId(), request.getAddressId());
        Building building = this.getReceiveBuilding(address.getBuildingId());
        order.setReceiveName(address.getReceiveName());
        order.setReceiveMobile(address.getMobile());
        order.setReceiveAddress(building.getBuildingName()+" "+address.getAddressInfo());
        order.setReceiveExpectTime(request.getReceiveExpectTime());
        order.setStatus(OrderStatus.NEW.getValue());
        return order;
    }

    private List<OrderGoods> requestToDomain(List<OrderGoodsRequest> request) {
        List<OrderGoods> orderGoodsList = BeanUtils.copyListProperties(OrderGoods.class, request);
        for (OrderGoods orderGoods : orderGoodsList) {
            Goods goods = goodsManager.getGoods(orderGoods.getGoodsId());
            orderGoods.setOrderGoodsId(genPrimaryKey(OrderGoods.class.getName()));
            orderGoods.setGoodsType1Id(goods.getGoodsType1Id());
            orderGoods.setGoodsType2Id(goods.getGoodsType2Id());
            orderGoods.setGoodsName(goods.getGoodsName());
            orderGoods.setUnitPrice(goods.getGoodsUnitPrice());
            orderGoods.setPrice(orderGoods.getUnitPrice() * orderGoods.getWeight());
        }
        return orderGoodsList;
    }

    @Override
    @Transactional
    public Long addOrder(OrderCreateRequest request) {
        BizAssert.notNull(request.getOrderType(), "orderType is required");
        BizAssert.notNull(request.getUserId(), "userId is required");
        BizAssert.notNull(request.getAddressId(), "addressId is required");
        BizAssert.notNull(request.getReceiveExpectTime(), "receiveExpectTime is required");

        if (CollectionUtils.isEmpty(request.getGoods())) ExceptionUtils.throwException(ZhufreshErrorCode.ORDER_NO_GOODS, ZhufreshErrorCode.ORDER_NO_GOODS.getMessage());

        List<OrderGoods> orderGoodsList = requestToDomain(request.getGoods());

        Order order = requestToDomain(request, orderGoodsList);
        orderMapper.insert(order);

        for (OrderGoods orderGoods : orderGoodsList) {
            orderGoodsMapper.insert(orderGoods);
        }

        return order.getOrderId();
    }
}
