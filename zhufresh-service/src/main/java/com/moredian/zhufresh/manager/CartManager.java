package com.moredian.zhufresh.manager;

import com.moredian.zhufresh.request.PutInCartRequest;

public interface CartManager {

    boolean putIn(PutInCartRequest request);

}
