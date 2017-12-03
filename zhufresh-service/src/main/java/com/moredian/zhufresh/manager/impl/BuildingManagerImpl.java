package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.config.ServiceProperties;
import com.moredian.zhufresh.domain.Building;
import com.moredian.zhufresh.domain.BuildingGoods;
import com.moredian.zhufresh.domain.BuildingQueryCondition;
import com.moredian.zhufresh.domain.DeliverConfig;
import com.moredian.zhufresh.enums.BuildingStatus;
import com.moredian.zhufresh.manager.BuildingManager;
import com.moredian.zhufresh.mapper.BuildingGoodsMapper;
import com.moredian.zhufresh.mapper.BuildingMapper;
import com.moredian.zhufresh.mapper.DeliverConfigMapper;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.request.BuildingCreateRequest;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.BuildingUpdateRequest;
import com.moredian.zhufresh.request.DeliverConfigRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BuildingManagerImpl implements BuildingManager {

    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private DeliverConfigMapper deliverConfigMapper;
    @Autowired
    private BuildingGoodsMapper buildingGoodsMapper;
    @SI
    private IdgeneratorService idgeneratorService;
    @Autowired
    private ServiceProperties serviceProperties;

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

    @Override
    public boolean configDeliver(DeliverConfigRequest request) {
        BizAssert.notNull(request.getBuildingId(), "buildingId is required");
        BizAssert.notBlank(request.getTheDay(), "theDay is required");
        BizAssert.notBlank(request.getFromTime(), "fromTime is required");
        BizAssert.notBlank(request.getToTime(), "toTime is required");
        BizAssert.notNull(request.getLimitAmount(), "limitAmount is required");

        DeliverConfig deliverConfig = new DeliverConfig();
        deliverConfig.setDeliverConfigId(this.genPrimaryKey(DeliverConfig.class.getName()));
        deliverConfig.setBuildingId(request.getBuildingId());
        deliverConfig.setTheDay(request.getTheDay());
        deliverConfig.setFromTime(request.getFromTime());
        deliverConfig.setToTime(request.getToTime());
        deliverConfig.setLimitAmount(request.getLimitAmount());
        deliverConfig.setRealAmount(0);
        deliverConfigMapper.insertOrUpdate(deliverConfig);

        return true;
    }

    @Override
    public List<DeliverConfig> searchDeliverConfig(Long buildingId, String theDay) {
        BizAssert.notNull(buildingId, "buildingId is required");
        if(StringUtils.isBlank(theDay)) {

            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(hour < serviceProperties.getDeadlineHour()) { // 获取当日配送服务时间
                theDay = sdf.format(cal.getTime());
            } else { // 获取次日配送服务时间
                cal.add(Calendar.DATE, 1);
                theDay = sdf.format(cal.getTime());
            }

        }
        return deliverConfigMapper.findByBuildingId(buildingId, theDay);
    }

    @Override
    public Building getBuilding(Long buildingId) {
        return buildingMapper.load(buildingId);
    }

    @Override
    @Transactional
    public boolean configGoods(Long buildingId, List<Long> finalGoodsIds) {

        BizAssert.notNull(buildingId, "buildingId is required");
        BizAssert.notNull(finalGoodsIds);

        List<Long> existGoodsIds = buildingGoodsMapper.findGoodsIdByBuilding(buildingId);
        List<Long> tempFinalGoodsIds = new ArrayList<>();
        tempFinalGoodsIds.addAll(finalGoodsIds);

        tempFinalGoodsIds.removeAll(existGoodsIds); // 定位新增的
        for (Long goodsId : tempFinalGoodsIds) {
            BuildingGoods buildingGoods = new BuildingGoods();
            buildingGoods.setBuildingGoodsId(genPrimaryKey(BuildingGoods.class.getName()));
            buildingGoods.setBuildingId(buildingId);
            buildingGoods.setGoodsId(goodsId);
            buildingGoodsMapper.insert(buildingGoods);
        }

        existGoodsIds.removeAll(finalGoodsIds); // 定位删除的
        for (Long goodsId : existGoodsIds) {
            buildingGoodsMapper.deleteOne(buildingId, goodsId);
        }

        return true;
    }

    @Override
    public List<Long> findGoodsIdByBuilding(Long buildingId) {
        return buildingGoodsMapper.findGoodsIdByBuilding(buildingId);
    }
}
