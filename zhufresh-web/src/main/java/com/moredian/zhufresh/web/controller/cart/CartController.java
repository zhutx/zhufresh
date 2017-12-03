package com.moredian.zhufresh.web.controller.cart;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.CartInfo;
import com.moredian.zhufresh.request.CartUpdateRequest;
import com.moredian.zhufresh.request.PutInCartRequest;
import com.moredian.zhufresh.service.CartService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.cart.request.CartClearModel;
import com.moredian.zhufresh.web.controller.cart.request.CartUpdateModel;
import com.moredian.zhufresh.web.controller.cart.request.PutInCartModel;
import com.moredian.zhufresh.web.controller.cart.response.CartData;
import com.moredian.zhufresh.web.controller.cart.response.CartGoodsData;
import com.moredian.zhufresh.web.controller.goods.request.GoodsCreateModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        cartService.putIn(buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/clear", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse clear(@RequestBody CartClearModel model) {
        cartService.clear(model.getUserId()).pickDataThrowException();
        return new BaseResponse();
    }

    private CartUpdateRequest buildRequest(CartUpdateModel model) {
        return BeanUtils.copyProperties(CartUpdateRequest.class, model);
    }

    @RequestMapping(value="/update", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResponse update(@RequestBody CartUpdateModel model) {
        cartService.update(buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }

    private CartData cartInfoToCartData(CartInfo cartInfo) {
        CartData cartData = BeanUtils.copyProperties(CartData.class, cartInfo);
        List<CartGoodsData> cartGoodsDataList = BeanUtils.copyListProperties(CartGoodsData.class, cartInfo.getGoods());
        cartData.setGoods(cartGoodsDataList);
        return cartData;
    }

    @RequestMapping(value="/info", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse info(@RequestParam("userId") Long userId, @RequestParam("addressId") Long addressId) {
        CartInfo cartInfo = cartService.getCartInfo(userId, addressId);
        CartData cartData = cartInfoToCartData(cartInfo);
        BaseResponse<CartData> br = new BaseResponse<>();
        br.setData(cartData);
        return br;
    }

}
