package com.moredian.tuna.certification.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.tuna.certification.model.AuthRecordInfo;
import com.moredian.tuna.certification.request.AuthRecordSearchRequest;
import com.moredian.tuna.certification.request.InputCertNoRequest;
import com.moredian.tuna.certification.request.NormalAuthRequest;

public interface AuthService {
	
	Pagination<AuthRecordInfo> findAuthRecord(Pagination<AuthRecordInfo> pagination, AuthRecordSearchRequest request);
	
	ServiceResponse<Long> normalAuth(NormalAuthRequest request);
	
	ServiceResponse<Long> inputCertNoAuth(InputCertNoRequest request);
	
	AuthRecordInfo getAuth(Long authRecordI);

}
