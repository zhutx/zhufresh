package com.moredian.tuna.certification.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.fishnet.device.request.CertificationDeviceSearchRequest;
import com.moredian.fishnet.device.response.CertificationDeviceInfo;
import com.moredian.fishnet.device.service.CertificationDeviceService;
import com.moredian.tuna.certification.domain.AuthTop;
import com.moredian.tuna.certification.manager.PlaceManager;
import com.moredian.tuna.certification.model.AuthRecordInfo;
import com.moredian.tuna.certification.request.AuthCollSearchRequest;
import com.moredian.tuna.certification.response.AuthCollInfo;
import com.moredian.tuna.certification.response.AuthFailTopInfo;
import com.moredian.tuna.certification.response.AuthTopInfo;
import com.moredian.tuna.certification.service.PlaceService;

@SI
public class PlaceServiceImpl implements PlaceService {
	
	@Autowired
	private PlaceManager placeManager;
	@SI
	private CertificationDeviceService certificationDeviceService;
	
	private List<AuthTopInfo> authTopToAuthTopInfoList(List<AuthTop> authTopList) {
		return BeanUtils.copyListProperties(AuthTopInfo.class, authTopList);
	}

	@Override
	public List<AuthTopInfo> findAuthTop(Integer areaCode, String topDirection) {
		List<AuthTop> authTopList = placeManager.findAuthTop(areaCode, topDirection);
		return this.authTopToAuthTopInfoList(authTopList);
	}
	
	private List<AuthFailTopInfo> authTopToAuthFailTopInfoList(List<AuthTop> authTopList) {
		return BeanUtils.copyListProperties(AuthFailTopInfo.class, authTopList);
	}

	@Override
	public List<AuthFailTopInfo> findAuthFailTop(Integer areaCode, String topDirection) {
		List<AuthTop> authTopList = placeManager.findAuthFailTop(areaCode, topDirection);
		return this.authTopToAuthFailTopInfoList(authTopList);
	}
	
	private Pagination<CertificationDeviceInfo> buildPagination(Pagination<AuthRecordInfo> pagination) {
		Pagination<CertificationDeviceInfo> toPagination = new Pagination<>();
		toPagination.setPageNo(pagination.getPageNo());
		toPagination.setPageSize(pagination.getPageSize());
		return toPagination;
	}
	
	private CertificationDeviceSearchRequest buildRequest(AuthCollSearchRequest request) {
		return BeanUtils.copyProperties(CertificationDeviceSearchRequest.class, request);
	}
	
	private Pagination<AuthCollInfo> paginationDeviceInfoPaginationAuthCollInfo(Pagination<CertificationDeviceInfo> fromPagination) {
		Pagination<AuthCollInfo> toPagination = new Pagination<>();
		toPagination.setPageNo(fromPagination.getPageNo());
		toPagination.setPageSize(fromPagination.getPageSize());
		toPagination.setTotalCount(fromPagination.getTotalCount());
		toPagination.setData(BeanUtils.copyListProperties(AuthCollInfo.class, fromPagination.getData()));
		return toPagination;
	}

	@Override
	public Pagination<AuthCollInfo> findAuthColl(Pagination<AuthRecordInfo> pagination,
			AuthCollSearchRequest request) {
		
		Pagination<CertificationDeviceInfo> paginationDeviceInfo = certificationDeviceService.findDevice(buildPagination(pagination), buildRequest(request));
		
		return paginationDeviceInfoPaginationAuthCollInfo(paginationDeviceInfo);
	}

}
