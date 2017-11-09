package com.moredian.zhufresh.web.controller.address;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.AddressInfo;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.request.AddressCreateRequest;
import com.moredian.zhufresh.request.AddressUpdateRequest;
import com.moredian.zhufresh.request.BuildingUpdateRequest;
import com.moredian.zhufresh.service.AddressService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.address.request.AddressCreateModel;
import com.moredian.zhufresh.web.controller.address.request.AddressDeleteModel;
import com.moredian.zhufresh.web.controller.address.request.AddressUpdateModel;
import com.moredian.zhufresh.web.controller.address.response.AddressData;
import com.moredian.zhufresh.web.controller.building.request.BuildingDeleteModel;
import com.moredian.zhufresh.web.controller.building.request.BuildingQueryModel;
import com.moredian.zhufresh.web.controller.building.request.BuildingUpdateModel;
import com.moredian.zhufresh.web.controller.building.response.PaginationBuildingData;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.Address;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/address")
public class AddressController extends BaseController {

    @SI
    private AddressService addressService;

    private AddressCreateRequest buildRequest(AddressCreateModel model) {
        return BeanUtils.copyProperties(AddressCreateRequest.class, model);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse create(@RequestBody AddressCreateModel model) {
        ServiceResponse<Long> sr = addressService.createAddress(this.buildRequest(model));
        if (!sr.isSuccess()) sr.pickDataThrowException();
        BaseResponse<Long> br = new BaseResponse<>();
        br.setData(sr.getData());
        return br;
    }

    private AddressUpdateRequest buildRequest(AddressUpdateModel model) {
        return BeanUtils.copyProperties(AddressUpdateRequest.class, model);
    }

    @RequestMapping(value="/update", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResponse update(@RequestBody AddressUpdateModel model) {
        addressService.updateAddress(this.buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse update(@RequestBody AddressDeleteModel model) {
        addressService.deleteAddress(model.getUserId(), model.getAddressId()).pickDataThrowException();
        return new BaseResponse();
    }

    private List<AddressData> addressInfoListToAddressDataList(List<AddressInfo> addressInfos) {
        return BeanUtils.copyListProperties(AddressData.class, addressInfos);
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "userId") Long userId) {
        List<AddressInfo> addressInfos = addressService.searchAddress(userId);
        BaseResponse<List<AddressData>> br = new BaseResponse<>();
        br.setData(addressInfoListToAddressDataList(addressInfos));
        return br;

    }

}
