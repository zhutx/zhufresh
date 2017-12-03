package com.moredian.zhufresh.web.controller.building;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.model.DeliverConfigInfo;
import com.moredian.zhufresh.request.BuildingCreateRequest;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.BuildingUpdateRequest;
import com.moredian.zhufresh.request.DeliverConfigRequest;
import com.moredian.zhufresh.service.BuildingService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.building.request.*;
import com.moredian.zhufresh.web.controller.building.response.BuildingData;
import com.moredian.zhufresh.web.controller.building.response.DeliverConfigData;
import com.moredian.zhufresh.web.controller.building.response.PaginationBuildingData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/building")
public class BuildingController extends BaseController {

    @SI
    private BuildingService buildingService;

    private BuildingCreateRequest buildRequest(BuildingCreateModel model) {
        return BeanUtils.copyProperties(BuildingCreateRequest.class, model);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse create(@RequestBody BuildingCreateModel model) {
        ServiceResponse<Long> sr = buildingService.createBuilding(this.buildRequest(model));
        if (!sr.isSuccess()) sr.pickDataThrowException();
        BaseResponse<Long> br = new BaseResponse<>();
        br.setData(sr.getData());
        return br;

    }

    private BuildingUpdateRequest buildRequest(BuildingUpdateModel model) {
        return BeanUtils.copyProperties(BuildingUpdateRequest.class, model);
    }

    @RequestMapping(value="/update", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResponse update(@RequestBody BuildingUpdateModel model) {
        buildingService.updateBuilding(this.buildRequest(model)).pickDataThrowException();
        return new BaseResponse();

    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse update(@RequestBody BuildingDeleteModel model) {
        buildingService.deleteBuilding(model.getBuildingId()).pickDataThrowException();
        return new BaseResponse();

    }

    @RequestMapping(value="/enable", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse enable(@RequestBody BuildingEnableModel model) {
        buildingService.enableBuilding(model.getBuildingId()).pickDataThrowException();
        return new BaseResponse();

    }

    @RequestMapping(value="/disable", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse disable(@RequestBody BuildingDisableModel model) {
        buildingService.disableBuilding(model.getBuildingId()).pickDataThrowException();
        return new BaseResponse();

    }

    private BuildingQueryRequest buildRequest(BuildingQueryModel model) {
        return BeanUtils.copyProperties(BuildingQueryRequest.class, model);
    }

    private Pagination<BuildingInfo> buildPagination(int pageNo, int pageSize) {
        Pagination<BuildingInfo> pagination = new Pagination<>();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        return pagination;
    }

    private PaginationBuildingData paginationToPaginationData(Pagination<BuildingInfo> pagination) {
        PaginationBuildingData data = new PaginationBuildingData();
        data.setPageNo(pagination.getPageNo());
        data.setTotalCount(pagination.getTotalCount());
        data.setBuildings(BeanUtils.copyListProperties(BuildingData.class, pagination.getData()));
        return data;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "provCode", required = false) Integer provCode, @RequestParam(value = "cityCode", required = false) Integer cityCode, @RequestParam(value = "districtCode", required = false) Integer districtCode, @RequestParam(value = "keywords", required = false) String keywords) {

        BuildingQueryModel model = new BuildingQueryModel();
        model.setProvCode(provCode);
        model.setCityCode(cityCode);
        model.setDistrictCode(districtCode);
        model.setKeywords(keywords);

        Pagination<BuildingInfo> pagination = buildingService.searchBuilding(this.buildRequest(model), this.buildPagination(model.getPageNo(), model.getPageSize()));
        BaseResponse<PaginationBuildingData> br = new BaseResponse<>();
        br.setData(paginationToPaginationData(pagination));
        return br;

    }

    private DeliverConfigRequest buildRequest(DeliverConfigModel model) {
        return BeanUtils.copyProperties(DeliverConfigRequest.class, model);
    }

    @RequestMapping(value="/deliver/config", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse deliverConfig(@RequestBody DeliverConfigModel model) {
        buildingService.configDeliver(this.buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }

    private List<DeliverConfigData> buildData(List<DeliverConfigInfo> infos) {
        return BeanUtils.copyListProperties(DeliverConfigData.class, infos);
    }

    @RequestMapping(value="/deliver/config", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse deliverConfig(@RequestParam(value="buildingId") Long buildingId, @RequestParam(value = "theDay", required = false) String theDay) {
        List<DeliverConfigInfo> deliverConfigInfos = buildingService.searchDeliverConfig(buildingId, theDay);
        BaseResponse<List<DeliverConfigData>> br = new BaseResponse<>();
        br.setData(this.buildData(deliverConfigInfos));
        return br;
    }

    @RequestMapping(value="/goods/config", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse goodsConfig(@RequestBody BuildingGoodsConfigModel model) {
        buildingService.configGoods(model.getBuildingId(), model.getGoodsIds()).pickDataThrowException();
        return new BaseResponse();
    }

}
