package com.moredian.tuna.certification.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.moredian.tuna.certification.domain.AuthDist;

@Mapper
public interface AuthDistMapper {
	
	List<AuthDist> findByAreaCode(Integer areaCode);

}
