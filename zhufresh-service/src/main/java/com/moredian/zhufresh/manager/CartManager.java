package com.moredian.zhufresh.manager;

import com.moredian.zhufresh.domain.Cart;
import com.moredian.zhufresh.domain.CartGoods;
import com.moredian.zhufresh.request.CartUpdateRequest;
import com.moredian.zhufresh.request.PutInCartRequest;

import java.util.List;

public interface CartManager {

    boolean putIn(PutInCartRequest request);

    boolean clear(Long userId);

    boolean update(CartUpdateRequest request);

    Cart getCartByUser(Long userId);

    List<CartGoods> findByCart(Long cartId);

}
