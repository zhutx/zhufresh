package com.moredian.zhufresh.manager;

import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.zhufresh.domain.Building;
import com.moredian.zhufresh.domain.DeliverConfig;
import com.moredian.zhufresh.enums.BuildingStatus;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.request.BuildingCreateRequest;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.BuildingUpdateRequest;
import com.moredian.zhufresh.request.DeliverConfigRequest;

import java.util.List;

public interface BuildingManager {

    PaginationDomain<Building> searchBuilding(BuildingQueryRequest request, Pagination<BuildingInfo> pagination);

    Long addBuilding(BuildingCreateRequest request);

    boolean updateBuilding(BuildingUpdateRequest request);

    boolean deleteBuilding(Long buildingId);

    boolean updateStatus(Long buildingId, BuildingStatus buildingStatus);

    boolean configDeliver(DeliverConfigRequest request);

    List<DeliverConfig> searchDeliverConfig(Long buildingId, String theDay);

    Building getBuilding(Long buildingId);

    boolean configGoods(Long buildingId, List<Long> goodsIds);
}
