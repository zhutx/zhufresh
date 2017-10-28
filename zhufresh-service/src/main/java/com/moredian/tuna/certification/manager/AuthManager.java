package com.moredian.tuna.certification.manager;

import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.tuna.certification.domain.AuthRecord;
import com.moredian.tuna.certification.model.AuthRecordInfo;
import com.moredian.tuna.certification.request.AuthRecordSearchRequest;
import com.moredian.tuna.certification.request.InputCertNoRequest;
import com.moredian.tuna.certification.request.NormalAuthRequest;

public interface AuthManager {
	
	PaginationDomain<AuthRecord> findAuthRecord(Pagination<AuthRecordInfo> pagination, AuthRecordSearchRequest request);
	
	Long auth(NormalAuthRequest request);
	
	Long auth(InputCertNoRequest request);
	
	AuthRecord getAuth(Long authRecordId);

}
