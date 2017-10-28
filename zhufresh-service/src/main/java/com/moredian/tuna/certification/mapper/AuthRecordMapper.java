package com.moredian.tuna.certification.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.moredian.tuna.certification.domain.AuthRecord;
import com.moredian.tuna.certification.domain.AuthRecordQueryCondition;

@Mapper
public interface AuthRecordMapper {
	
	int getTotalCountByCondition(AuthRecordQueryCondition condition);
	
	List<AuthRecord> findPaginationByCondition(AuthRecordQueryCondition condition);
	
	int insert(AuthRecord authRecord);
	
	AuthRecord load(@Param("authRecordId")Long authRecordId);

}
