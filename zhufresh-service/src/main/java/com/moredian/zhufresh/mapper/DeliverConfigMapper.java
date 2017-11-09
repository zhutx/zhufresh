package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.DeliverConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeliverConfigMapper {

    int insertOrUpdate(DeliverConfig deliverConfig);

    List<DeliverConfig> findByBuildingId(@Param("buildingId") Long buildingId, @Param("theDay") String theDay);

}
