package com.moredian.zhufresh.web.controller.goodsType;

import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.AddressInfo;
import com.moredian.zhufresh.model.GoodsTypeInfo;
import com.moredian.zhufresh.service.GoodsTypeService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.address.response.AddressData;
import com.moredian.zhufresh.web.controller.building.request.DeliverConfigModel;
import com.moredian.zhufresh.web.controller.goodsType.request.GoodsTypeCreateModel;
import com.moredian.zhufresh.web.controller.goodsType.response.GoodsTypeData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public BaseResponse getGoodsTypeDatas() {

        List<GoodsTypeData> data = new ArrayList<>();

        List<GoodsTypeInfo> goodsType1s = goodsTypeService.findByParent(0L);

        for(GoodsTypeInfo goodsType1Info : goodsType1s) {

            GoodsTypeData goodsType1data = BeanUtils.copyProperties(GoodsTypeData.class, goodsType1Info);

            List<GoodsTypeInfo> goodsType2s = goodsTypeService.findByParent(goodsType1Info.getGoodsTypeId());

            goodsType1data.setChildren(BeanUtils.copyListProperties(GoodsTypeData.class, goodsType2s));

            data.add(goodsType1data);
        }

        BaseResponse<List<GoodsTypeData>> br = new BaseResponse<>();

        br.setData(data);

        return br;

    }

}
