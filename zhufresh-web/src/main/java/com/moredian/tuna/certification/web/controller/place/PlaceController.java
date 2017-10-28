package com.moredian.tuna.certification.web.controller.place;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.fishnet.org.enums.PoliceOrgLevel;
import com.moredian.fishnet.org.model.OrgInfo;
import com.moredian.fishnet.org.service.OrgService;
import com.moredian.tuna.certification.model.AuthRecordInfo;
import com.moredian.tuna.certification.model.SessionUser;
import com.moredian.tuna.certification.request.AuthCollSearchRequest;
import com.moredian.tuna.certification.response.AuthCollInfo;
import com.moredian.tuna.certification.response.AuthFailTopInfo;
import com.moredian.tuna.certification.response.AuthTopInfo;
import com.moredian.tuna.certification.service.PlaceService;
import com.moredian.tuna.certification.web.controller.BaseController;
import com.moredian.tuna.certification.web.controller.place.response.AuthCollData;
import com.moredian.tuna.certification.web.controller.place.response.AuthTimesData;
import com.moredian.tuna.certification.web.controller.place.response.PaginationAuthCollData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Place API", description = "认证点接口")
@RequestMapping("/place")
public class PlaceController extends BaseController {
	
	@SI
	private PlaceService placeService;
	@SI
	private OrgService orgService;
	
	private AuthTimesData authTopInfoToAuthTimesData(AuthTopInfo authTopInfo) {
		AuthTimesData data = new AuthTimesData();
		data.setOrgId(authTopInfo.getOrgId());
		data.setOrgName(authTopInfo.getOrgName());
		data.setTimes(authTopInfo.getAuthTimes());
		return data;
	}
	
	private List<AuthTimesData> buildAuthTimesDataList(List<AuthTopInfo> authTopInfoList) {
		List<AuthTimesData> authTimesDataList = new ArrayList<>(); 
		if(CollectionUtils.isEmpty(authTopInfoList)) return authTimesDataList;
		
		for(AuthTopInfo authTopInfo : authTopInfoList) {
			authTimesDataList.add(authTopInfoToAuthTimesData(authTopInfo));
		}
		
		return authTimesDataList;
	}
	
	@ApiOperation(value="获取认证数TOP", notes="获取认证数TOP")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/authTop", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse authTop(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "topDirection")String topDirection, HttpServletRequest request) {
		
		BaseResponse<List<AuthTimesData>> bdr = new BaseResponse<>();
		
		orgId = this.getSessionUser(request).getOrgId();
		
		Integer areaCode = null;
		
		OrgInfo bizOrg = orgService.getOrgInfo(bizOrgId);
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.PROV.getValue()) {
			areaCode = bizOrg.getProvinceId();
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.CITY.getValue()) {
			areaCode = bizOrg.getCityId();
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.DISTRICT.getValue()) {
			areaCode = bizOrg.getDistrictId();
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.TOWN.getValue()) {
			areaCode = bizOrg.getDistrictId();
		}
		
		List<AuthTopInfo> authTopInfoList = placeService.findAuthTop(areaCode, topDirection);
		
		bdr.setData(buildAuthTimesDataList(authTopInfoList));
		
		return bdr;
    }
	
	private AuthTimesData authFailTopInfoToAuthTimesData(AuthFailTopInfo authFailTopInfo) {
		AuthTimesData data = new AuthTimesData();
		data.setOrgId(authFailTopInfo.getOrgId());
		data.setOrgName(authFailTopInfo.getOrgName());
		data.setTimes(authFailTopInfo.getFailTimes());
		return data;
	}
	
	private List<AuthTimesData> buildAuthFailTimesDataList(List<AuthFailTopInfo> autoFailTopInfoList) {
		List<AuthTimesData> authTimesDataList = new ArrayList<>(); 
		if(CollectionUtils.isEmpty(autoFailTopInfoList)) return authTimesDataList;
		
		for(AuthFailTopInfo authFailTopInfo : autoFailTopInfoList) {
			authTimesDataList.add(authFailTopInfoToAuthTimesData(authFailTopInfo));
		}
		
		return authTimesDataList;
	}
	
	@ApiOperation(value="获取认证异常数TOP", notes="获取认证异常数TOP")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/failTop", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse failTop(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "topDirection")String topDirection, HttpServletRequest request) {
		
		BaseResponse<List<AuthTimesData>> bdr = new BaseResponse<>();
		
		orgId = this.getSessionUser(request).getOrgId();
		
		Integer areaCode = null;
		
		OrgInfo bizOrg = orgService.getOrgInfo(bizOrgId);
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.PROV.getValue()) {
			areaCode = bizOrg.getProvinceId();
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.CITY.getValue()) {
			areaCode = bizOrg.getCityId();
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.DISTRICT.getValue()) {
			areaCode = bizOrg.getDistrictId();
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.TOWN.getValue()) {
			areaCode = bizOrg.getDistrictId();
		}
		
		List<AuthFailTopInfo> autoFailTopInfoList = placeService.findAuthFailTop(areaCode, topDirection);
		
		bdr.setData(buildAuthFailTimesDataList(autoFailTopInfoList));
		
		return bdr;
    }
	
	private Pagination<AuthRecordInfo> buildPagination(int pageNo, int pageSize) {
		Pagination<AuthRecordInfo> pagination = new Pagination<>();
		pagination.setPageNo(pageNo);
		pagination.setPageSize(pageSize);
		return pagination;
	}
	
	private AuthCollSearchRequest buildRequest(Integer provCode, Integer cityCode, Integer districtCode, Integer townCode, Integer onlineFlag, String orgName) {
		AuthCollSearchRequest request = new AuthCollSearchRequest();
		request.setProvCode(provCode);
		request.setCityCode(cityCode);
		request.setDistrictCode(districtCode);
		request.setTownCode(townCode);
		request.setOnlineFlag(onlineFlag);
		request.setOrgName(orgName);
		return request;
	}
	
	private PaginationAuthCollData buildPaginationAuthCollData(Pagination<AuthCollInfo> pagination) {
		PaginationAuthCollData data = new PaginationAuthCollData();
		data.setPageNo(pagination.getPageNo());
		data.setTotalCount(pagination.getTotalCount());
		List<AuthCollData> infos = BeanUtils.copyListProperties(AuthCollData.class, pagination.getData());
		data.setInfos(infos);
		return data;
	}
	
	@ApiOperation(value="查询认证汇总数据", notes="查询认证汇总数据")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse list(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId")Long bizOrgId, @RequestParam(value = "pageNo")Integer pageNo, @RequestParam(value = "pageSize")Integer pageSize, @RequestParam(value = "searchAreaCode", required = false)Integer searchAreaCode, @RequestParam(value = "onlineFlag", required = false)Integer onlineFlag, @RequestParam(value = "orgName", required = false)String orgName, HttpServletRequest request) {
		
		BaseResponse<PaginationAuthCollData> bdr = new BaseResponse<>();
		
		SessionUser sessionUser = this.getSessionUser(request);
		
		orgId = sessionUser.getOrgId();
		
		Integer provCode = sessionUser.getProvCode();
		Integer cityCode = null;
		Integer districtCode = null;
		Integer townCode = null;
		
		OrgInfo bizOrg = orgService.getOrgInfo(bizOrgId);
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.PROV.getValue()) {
			cityCode = searchAreaCode;
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.CITY.getValue()) {
			districtCode = searchAreaCode;
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.DISTRICT.getValue()) {
			townCode = searchAreaCode;
		}
		if(bizOrg.getOrgLevel() == PoliceOrgLevel.TOWN.getValue()) {
			townCode = searchAreaCode;
		}
		
		Pagination<AuthCollInfo> pagination = placeService.findAuthColl(this.buildPagination(pageNo, pageSize), this.buildRequest(provCode, cityCode, districtCode, townCode, onlineFlag, orgName));
		
		bdr.setData(this.buildPaginationAuthCollData(pagination));
		
		return bdr;
    }

}
