package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.model.DeliverConfigInfo;
import com.moredian.zhufresh.request.BuildingCreateRequest;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.BuildingUpdateRequest;
import com.moredian.zhufresh.request.DeliverConfigRequest;

import java.util.List;

public interface BuildingService {

    Pagination<BuildingInfo> searchBuilding(BuildingQueryRequest request, Pagination<BuildingInfo> pagination);

    ServiceResponse<Long> createBuilding(BuildingCreateRequest request);

    ServiceResponse<Boolean> updateBuilding(BuildingUpdateRequest request);

    ServiceResponse<Boolean> deleteBuilding(Long buildingId);

    ServiceResponse<Boolean>  enableBuilding(Long buildingId);

    ServiceResponse<Boolean> disableBuilding(Long buildingId);

    ServiceResponse<Boolean> configDeliver(DeliverConfigRequest request);

    List<DeliverConfigInfo> searchDeliverConfig(Long buildingId, String theDay);

}
