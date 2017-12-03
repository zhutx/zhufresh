package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.Address;
import com.moredian.zhufresh.domain.Cart;
import com.moredian.zhufresh.domain.CartGoods;
import com.moredian.zhufresh.domain.Goods;
import com.moredian.zhufresh.enums.CartGoodsStatus;
import com.moredian.zhufresh.manager.AddressManager;
import com.moredian.zhufresh.manager.BuildingManager;
import com.moredian.zhufresh.manager.CartManager;
import com.moredian.zhufresh.manager.GoodsManager;
import com.moredian.zhufresh.mapper.CartMapper;
import com.moredian.zhufresh.model.CartGoodsFullInfo;
import com.moredian.zhufresh.model.CartGoodsInfo;
import com.moredian.zhufresh.model.CartInfo;
import com.moredian.zhufresh.request.CartUpdateRequest;
import com.moredian.zhufresh.request.PutInCartRequest;
import com.moredian.zhufresh.service.CartService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SI
public class CartServiceImpl implements CartService {

    @Autowired
    private CartManager cartManager;
    @Autowired
    private GoodsManager goodsManager;
    @Autowired
    private AddressManager addressManager;
    @Autowired
    private BuildingManager buildingManager;

    @Override
    public ServiceResponse<Boolean> putIn(PutInCartRequest request) {
        boolean result = cartManager.putIn(request);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> clear(Long userId) {
        boolean result = cartManager.clear(userId);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> update(CartUpdateRequest request) {
        boolean result = cartManager.update(request);
        return new ServiceResponse<>(true, null, result);
    }

    private CartInfo cartToCartInfo(Cart cart) {
        if (cart == null) return null;
        return BeanUtils.copyProperties(CartInfo.class, cart);
    }

    private List<CartGoodsInfo> cartGoodsListToCartGoodsInfoList(List<CartGoods> cartGoodsList) {
        if (CollectionUtils.isEmpty(cartGoodsList)) return new ArrayList<>();
        return BeanUtils.copyListProperties(CartGoodsInfo.class, cartGoodsList);
    }

    private void buildCartInfo(CartInfo cartInfo, List<CartGoodsInfo> cartGoodsInfos, Long addressId) {

        Address address = addressManager.getAddress(cartInfo.getUserId(), addressId);
        List<Long> scopeGoodsId = buildingManager.findGoodsIdByBuilding(address.getBuildingId());

        List<CartGoodsFullInfo> cartGoodsFullInfos = BeanUtils.copyListProperties(CartGoodsFullInfo.class, cartGoodsInfos);

        for (CartGoodsFullInfo cartGoodsFullInfo : cartGoodsFullInfos) {
            Goods goods = goodsManager.getGoods(cartGoodsFullInfo.getGoodsId());
            cartGoodsFullInfo.setUnit(goods.getGoodsUnit());
            cartGoodsFullInfo.setUnitPrice(goods.getGoodsUnitPrice());
            if (scopeGoodsId.contains(goods.getGoodsId())) {
                cartGoodsFullInfo.setStatus(CartGoodsStatus.UP.getValue());
            } else {
                cartGoodsFullInfo.setStatus(CartGoodsStatus.DOWN.getValue());
            }
        }

        cartInfo.setGoods(cartGoodsFullInfos);
    }

    @Override
    public CartInfo getCartInfo(Long userId, Long addressId) {
        Cart cart = cartManager.getCartByUser(userId);
        if (cart == null) return null;
        CartInfo cartInfo = cartToCartInfo(cart);

        List<CartGoods> cartGoodsList = cartManager.findByCart(cart.getCartId());
        List<CartGoodsInfo> cartGoodsInfos = cartGoodsListToCartGoodsInfoList(cartGoodsList);

        buildCartInfo(cartInfo, cartGoodsInfos, addressId);

        return cartInfo;
    }
}
