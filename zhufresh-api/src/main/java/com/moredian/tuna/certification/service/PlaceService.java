package com.moredian.tuna.certification.service;

import java.util.List;

import com.moredian.bee.common.utils.Pagination;
import com.moredian.tuna.certification.model.AuthRecordInfo;
import com.moredian.tuna.certification.request.AuthCollSearchRequest;
import com.moredian.tuna.certification.response.AuthCollInfo;
import com.moredian.tuna.certification.response.AuthFailTopInfo;
import com.moredian.tuna.certification.response.AuthTopInfo;

public interface PlaceService {
	
	List<AuthTopInfo> findAuthTop(Integer areaCode, String topDirection);
	
	List<AuthFailTopInfo> findAuthFailTop(Integer areaCode, String topDirection);
	
	Pagination<AuthCollInfo> findAuthColl(Pagination<AuthRecordInfo> pagination, AuthCollSearchRequest request);
	
}
