package com.moredian.zhufresh.web.controller.goods;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.model.GoodsInfo;
import com.moredian.zhufresh.request.AddressUpdateRequest;
import com.moredian.zhufresh.request.GoodsQueryRequest;
import com.moredian.zhufresh.request.GoodsCreateRequest;
import com.moredian.zhufresh.request.GoodsUpdateRequest;
import com.moredian.zhufresh.service.GoodsService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.address.request.AddressDeleteModel;
import com.moredian.zhufresh.web.controller.address.request.AddressUpdateModel;
import com.moredian.zhufresh.web.controller.building.request.BuildingQueryModel;
import com.moredian.zhufresh.web.controller.building.response.BuildingData;
import com.moredian.zhufresh.web.controller.building.response.PaginationBuildingData;
import com.moredian.zhufresh.web.controller.goods.request.*;
import com.moredian.zhufresh.web.controller.goods.response.GoodsData;
import com.moredian.zhufresh.web.controller.goods.response.PaginationGoodsData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/goods")
public class GoodsController extends BaseController {

    @SI
    private GoodsService goodsService;

    private GoodsCreateRequest buildRequest(GoodsCreateModel model) {
        return BeanUtils.copyProperties(GoodsCreateRequest.class, model);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse create(@RequestBody GoodsCreateModel model) {
        ServiceResponse<Long> sr = goodsService.createGoods(this.buildRequest(model));
        if (!sr.isSuccess()) sr.pickDataThrowException();
        BaseResponse<Long> br = new BaseResponse<>();
        br.setData(sr.getData());
        return br;
    }

    private GoodsUpdateRequest buildRequest(GoodsUpdateModel model) {
        return BeanUtils.copyProperties(GoodsUpdateRequest.class, model);
    }

    @RequestMapping(value="/update", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResponse update(@RequestBody GoodsUpdateModel model) {
        goodsService.updateGoods(this.buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse delete(@RequestBody GoodsDeleteModel model) {
        goodsService.deleteGoods(model.getGoodsId()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/enable", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse enable(@RequestBody GoodsEnableModel model) {
        goodsService.enableGoods(model.getGoodsId()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/disable", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse disable(@RequestBody GoodsDisableModel model) {
        goodsService.disableGoods(model.getGoodsId()).pickDataThrowException();
        return new BaseResponse();
    }

    private GoodsData goodsInfoToGoodsData(GoodsInfo goodsInfo) {
        if (goodsInfo == null) return null;
        return BeanUtils.copyProperties(GoodsData.class, goodsInfo);
    }

    @RequestMapping(value="/info", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse info(@RequestParam(value = "goodsId") Long goodsId) {
        GoodsInfo goodsInfo = goodsService.getGoods(goodsId);
        GoodsData data = goodsInfoToGoodsData(goodsInfo);
        BaseResponse<GoodsData> br = new BaseResponse<>();
        br.setData(data);
        return br;
    }

    private GoodsQueryRequest buildRequest(GoodsQueryModel model) {
        return BeanUtils.copyProperties(GoodsQueryRequest.class, model);
    }

    private Pagination<GoodsInfo> buildPagination(int pageNo, int pageSize) {
        Pagination<GoodsInfo> pagination = new Pagination<>();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        return pagination;
    }

    private PaginationGoodsData paginationToPaginationData(Pagination<GoodsInfo> pagination) {
        PaginationGoodsData data = new PaginationGoodsData();
        data.setPageNo(pagination.getPageNo());
        data.setTotalCount(pagination.getTotalCount());
        data.setGoodsList(BeanUtils.copyListProperties(GoodsData.class, pagination.getData()));
        return data;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "userId", required = false) Long userId, @RequestParam(value = "addressId", required = false) Long addressId, @RequestParam(value = "goodsType1Id", required = false) Long goodsType1Id, @RequestParam(value = "goodsType2Id", required = false) Long goodsType2Id, @RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "status", required = false) Integer status) {

        GoodsQueryModel model = new GoodsQueryModel();
        model.setUserId(userId);
        model.setAddressId(addressId);
        model.setGoodsType1Id(goodsType1Id);
        model.setGoodsType2Id(goodsType2Id);
        model.setKeywords(keywords);
        model.setStatus(status);

        Pagination<GoodsInfo> pagination = goodsService.searchGoods(this.buildRequest(model), this.buildPagination(model.getPageNo(), model.getPageSize()));
        BaseResponse<PaginationGoodsData> br = new BaseResponse<>();
        br.setData(paginationToPaginationData(pagination));
        return br;

    }

}
