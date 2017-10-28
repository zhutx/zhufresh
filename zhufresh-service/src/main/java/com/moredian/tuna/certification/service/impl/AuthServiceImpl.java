package com.moredian.tuna.certification.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.tuna.certification.domain.AuthRecord;
import com.moredian.tuna.certification.manager.AuthManager;
import com.moredian.tuna.certification.model.AuthRecordInfo;
import com.moredian.tuna.certification.request.NormalAuthRequest;
import com.moredian.tuna.certification.request.AuthRecordSearchRequest;
import com.moredian.tuna.certification.request.InputCertNoRequest;
import com.moredian.tuna.certification.service.AuthService;

@SI
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthManager authManager;
	
	@Override
	public ServiceResponse<Long> normalAuth(NormalAuthRequest request) {
		Long result = authManager.auth(request);
		return new ServiceResponse<Long>(true, null, result);
	}

	@Override
	public ServiceResponse<Long> inputCertNoAuth(InputCertNoRequest request) {
		Long result = authManager.auth(request);
		return new ServiceResponse<Long>(true, null, result);
	}

	private List<AuthRecordInfo> authRecordListToAuthRecordInfoList(List<AuthRecord> authRecordList) {
		List<AuthRecordInfo> authRecordInfoList = new ArrayList<>();
		if(CollectionUtils.isEmpty(authRecordList)) return authRecordInfoList;
		return BeanUtils.copyListProperties(AuthRecordInfo.class, authRecordList);
	}
	
	private Pagination<AuthRecordInfo> paginationAuthRecordToPaginationAuthRecordInfo(PaginationDomain<AuthRecord> fromPagination) {
		Pagination<AuthRecordInfo> toPagination = PaginationConvertor.paginationDomainToPagination(fromPagination, new Pagination<AuthRecordInfo>());
		if (toPagination == null)
			return null;
		toPagination.setData(authRecordListToAuthRecordInfoList(fromPagination.getData()));
		return toPagination;
	}

	@Override
	public Pagination<AuthRecordInfo> findAuthRecord(Pagination<AuthRecordInfo> pagination,
			AuthRecordSearchRequest request) {
		PaginationDomain<AuthRecord> paginationAuthRecord = authManager.findAuthRecord(pagination, request);
		return paginationAuthRecordToPaginationAuthRecordInfo(paginationAuthRecord);
	}
	
	private AuthRecordInfo authRecordToAuthRecordInfo(AuthRecord authRecord) {
		return BeanUtils.copyProperties(AuthRecordInfo.class, authRecord);
	}

	@Override
	public AuthRecordInfo getAuth(Long authRecordId) {
		AuthRecord authRecord = authManager.getAuth(authRecordId);
		return this.authRecordToAuthRecordInfo(authRecord);
	}

}
