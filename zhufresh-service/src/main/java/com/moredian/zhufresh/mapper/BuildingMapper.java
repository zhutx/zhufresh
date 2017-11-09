package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Building;
import com.moredian.zhufresh.domain.BuildingQueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BuildingMapper {

    int insert(Building building);

    int update(Building building);

    int delete(@Param("buildingId") Long buildingId);

    int updateStatus(@Param("buildingId") Long buildingId, @Param("status") Integer status);

    Building load(@Param("buildingId") Long buildingId);

    int getTotalCountByCondition(BuildingQueryCondition condition);

    List<Building> findPaginationByCondition(BuildingQueryCondition condition);

}
