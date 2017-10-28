package com.moredian.tuna.certification.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.moredian.tuna.certification.domain.PrivateCloud;

@Mapper
public interface PrivateCloudMapper {
	
	List<PrivateCloud> findAll();
	
}
