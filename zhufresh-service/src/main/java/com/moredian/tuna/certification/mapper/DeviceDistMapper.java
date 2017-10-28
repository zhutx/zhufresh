package com.moredian.tuna.certification.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.moredian.tuna.certification.domain.DeviceDist;

@Mapper
public interface DeviceDistMapper {
	
	List<DeviceDist> findByAreaCode(Integer areaCode);

}
