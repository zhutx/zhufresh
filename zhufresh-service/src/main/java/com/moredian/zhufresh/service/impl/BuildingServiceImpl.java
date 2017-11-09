package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.Building;
import com.moredian.zhufresh.enums.BuildingStatus;
import com.moredian.zhufresh.manager.BuildingManager;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.request.BuildingCreateRequest;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.BuildingUpdateRequest;
import com.moredian.zhufresh.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;

@SI
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingManager buildingManager;

    private Pagination<BuildingInfo> paginationDomainToPagination(PaginationDomain<Building> paginationDomain) {
        return null;
    }

    @Override
    public Pagination<BuildingInfo> searchBuilding(BuildingQueryRequest request, Pagination<BuildingInfo> pagination) {
        PaginationDomain<Building> paginationDomain = buildingManager.searchBuilding(request, pagination);
        return paginationDomainToPagination(paginationDomain);
    }

    @Override
    public ServiceResponse<Long> createBuilding(BuildingCreateRequest request) {
        Long result = buildingManager.addBuilding(request);
        return new ServiceResponse<Long>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> updateBuilding(BuildingUpdateRequest request) {
        boolean result = buildingManager.updateBuilding(request);
        return new ServiceResponse<Boolean>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> deleteBuilding(Long buildingId) {
        boolean result = buildingManager.deleteBuilding(buildingId);
        return new ServiceResponse<Boolean>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> enableBuilding(Long buildingId) {
        boolean result = buildingManager.updateStatus(buildingId, BuildingStatus.ENABLE);
        return new ServiceResponse<Boolean>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> disableBuilding(Long buildingId) {
        boolean result = buildingManager.updateStatus(buildingId, BuildingStatus.DISABLE);
        return new ServiceResponse<Boolean>(true, null, result);
    }
}
