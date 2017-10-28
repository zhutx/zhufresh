package com.moredian.tuna.certification.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.moredian.tuna.certification.domain.AuthTop;

@Mapper
public interface AuthTopMapper {
	
	List<AuthTop> findAuthTop(@Param("areaCode")Integer areaCode, @Param("topDirection")String topDirection);
	
	List<AuthTop> findAuthFailTop(@Param("areaCode")Integer areaCode, @Param("topDirection")String topDirection);

}
