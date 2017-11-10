package com.moredian.zhufresh.web.controller.goodsType;

import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.AddressInfo;
import com.moredian.zhufresh.service.GoodsTypeService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.address.response.AddressData;
import com.moredian.zhufresh.web.controller.building.request.DeliverConfigModel;
import com.moredian.zhufresh.web.controller.goodsType.request.GoodsTypeCreateModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/goodsType")
public class GoodsTypeController extends BaseController {

    @SI
    private GoodsTypeService goodsTypeService;

    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse deliverConfig(@RequestBody GoodsTypeCreateModel model) {
        goodsTypeService.createGoodsType(model.getGoodsTypeName(), model.getParentId()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/datas", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse getGoodsTypeDatas(@RequestParam(value = "userId") Long userId) {
        List<AddressInfo> addressInfos = addressService.searchAddress(userId);
        BaseResponse<List<AddressData>> br = new BaseResponse<>();
        br.setData(addressInfoListToAddressDataList(addressInfos));
        return br;

    }

}
