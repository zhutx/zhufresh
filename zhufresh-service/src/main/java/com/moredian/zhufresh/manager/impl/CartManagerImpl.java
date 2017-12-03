package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.Cart;
import com.moredian.zhufresh.domain.CartGoods;
import com.moredian.zhufresh.manager.CartManager;
import com.moredian.zhufresh.mapper.CartGoodsMapper;
import com.moredian.zhufresh.mapper.CartMapper;
import com.moredian.zhufresh.request.CartGoodsRequest;
import com.moredian.zhufresh.request.CartUpdateRequest;
import com.moredian.zhufresh.request.PutInCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartManagerImpl implements CartManager {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartGoodsMapper cartGoodsMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private Cart requestToDomain(PutInCartRequest request) {
        Cart cart = BeanUtils.copyProperties(Cart.class, request);
        cart.setCartId(genPrimaryKey(Cart.class.getName()));
        return cart;
    }

    private List<CartGoods> requestToDomain(Long cartId, List<CartGoodsRequest> request) {
        List<CartGoods> cartGoodsList = new ArrayList<>();
        for (CartGoodsRequest item : request) {
            CartGoods cartGoods = new CartGoods();
            cartGoods.setCartGoodsId(genPrimaryKey(CartGoods.class.getName()));
            cartGoods.setCartId(cartId);
            cartGoods.setGoodsId(item.getGoodsId());
            cartGoods.setWeight(item.getWeight());
            cartGoodsList.add(cartGoods);
        }
        return cartGoodsList;
    }

    @Override
    @Transactional
    public boolean putIn(PutInCartRequest request) {
        BizAssert.notNull(request.getUserId(), "userId is required");
        BizAssert.notEmpty(request.getGoods());

        Cart cart = cartMapper.loadByUser(request.getUserId());
        if (cart == null) {
            cart = requestToDomain(request);
            cartMapper.insert(cart);
        } else {
            cartMapper.update(cart);
        }

        List<CartGoods> cartGoodsList = requestToDomain(cart.getCartId(), request.getGoods());
        for (CartGoods cartGoods : cartGoodsList) {
            cartGoodsMapper.insertOrInc(cartGoods);
        }

        return true;
    }

    @Override
    @Transactional
    public boolean clear(Long userId) {
        Cart cart = cartMapper.loadByUser(userId);
        cartMapper.delete(cart.getCartId());
        cartGoodsMapper.deleteAll(cart.getCartId());
        return true;
    }

    @Override
    @Transactional
    public boolean update(CartUpdateRequest request) {

        Cart cart = cartMapper.loadByUser(request.getUserId());
        cartMapper.update(cart);

        List<CartGoods> cartGoodsList = requestToDomain(cart.getCartId(), request.getGoods());
        for (CartGoods cartGoods : cartGoodsList) {
            cartGoodsMapper.update(cartGoods);
        }

        return true;
    }
}
