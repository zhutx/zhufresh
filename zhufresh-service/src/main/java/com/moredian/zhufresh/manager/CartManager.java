package com.moredian.zhufresh.manager;

import com.moredian.zhufresh.request.CartUpdateRequest;
import com.moredian.zhufresh.request.PutInCartRequest;

public interface CartManager {

    boolean putIn(PutInCartRequest request);

    boolean clear(Long userId);

    boolean update(CartUpdateRequest request);

}
