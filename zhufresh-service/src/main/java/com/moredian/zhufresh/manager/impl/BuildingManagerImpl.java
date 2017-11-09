package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.Building;
import com.moredian.zhufresh.domain.BuildingQueryCondition;
import com.moredian.zhufresh.enums.BuildingStatus;
import com.moredian.zhufresh.manager.BuildingManager;
import com.moredian.zhufresh.mapper.BuildingMapper;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.request.BuildingCreateRequest;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.BuildingUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingManagerImpl implements BuildingManager {

    @Autowired
    private BuildingMapper buildingMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private BuildingQueryCondition requestToCondition(BuildingQueryRequest request) {
        return BeanUtils.copyProperties(BuildingQueryCondition.class, request);
    }

    private PaginationDomain<Building> paginationToPaginationDomain(Pagination<BuildingInfo> pagination) {
        return PaginationConvertor.paginationToPaginationDomain(pagination, new PaginationDomain<Building>());
    }

    protected PaginationDomain getPagination(PaginationDomain paginationDomain, BuildingQueryCondition queryCondition) {
        int totalCount = buildingMapper.getTotalCountByCondition(queryCondition);
        paginationDomain.setTotalCount(totalCount);
        if (totalCount > 0) {
            queryCondition.setStartRow(paginationDomain.getStartRow());
            queryCondition.setPageSize(paginationDomain.getPageSize());
            paginationDomain.setData(buildingMapper.findPaginationByCondition(queryCondition));
        }
        return paginationDomain;
    }

    @Override
    public PaginationDomain<Building> searchBuilding(BuildingQueryRequest request, Pagination<BuildingInfo> pagination) {

        BuildingQueryCondition queryCondition = requestToCondition(request);

        PaginationDomain<Building> paginationDomain = paginationToPaginationDomain(pagination);

        return this.getPagination(paginationDomain, queryCondition);
    }

    private Building buildDomain(BuildingCreateRequest request) {
        Building building = BeanUtils.copyProperties(Building.class, request);
        building.setBuildingId(this.genPrimaryKey(Building.class.getName()));
        building.setStatus(BuildingStatus.DISABLE.getValue());
        return building;
    }
    @Override
    public Long addBuilding(BuildingCreateRequest request) {
        BizAssert.notNull(request.getProvCode(), "provCode is required");
        BizAssert.notNull(request.getCityCode(), "cityCode is required");
        BizAssert.notNull(request.getDistrictCode(), "districtCode is required");
        BizAssert.notBlank(request.getBuildingName(), "buildingName is required");

        Building building = this.buildDomain(request);
        buildingMapper.insert(building);

        return building.getBuildingId();
    }

    private Building buildDomain(BuildingUpdateRequest request) {
        return BeanUtils.copyProperties(Building.class, request);
    }

    @Override
    public boolean updateBuilding(BuildingUpdateRequest request) {
        BizAssert.notNull(request.getBuildingId(), "buildingId is required");

        Building building = this.buildDomain(request);
        buildingMapper.update(building);

        return true;
    }

    @Override
    public boolean deleteBuilding(Long buildingId) {
        buildingMapper.delete(buildingId);
        return true;
    }

    @Override
    public boolean updateStatus(Long buildingId, BuildingStatus buildingStatus) {
        buildingMapper.updateStatus(buildingId, buildingStatus.getValue());
        return true;
    }
}
