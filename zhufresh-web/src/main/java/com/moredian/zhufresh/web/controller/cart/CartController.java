package com.moredian.zhufresh.web.controller.cart;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.request.PutInCartRequest;
import com.moredian.zhufresh.service.CartService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.cart.request.PutInCartModel;
import com.moredian.zhufresh.web.controller.goods.request.GoodsCreateModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/cart")
public class CartController extends BaseController {

    @SI
    private CartService cartService;

    private PutInCartRequest buildRequest(PutInCartModel model) {
        return BeanUtils.copyProperties(PutInCartRequest.class, model);
    }

    @RequestMapping(value="/putin", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse create(@RequestBody PutInCartModel model) {
        cartService.putIn(buildRequest(model));
        return new BaseResponse();
    }

}
