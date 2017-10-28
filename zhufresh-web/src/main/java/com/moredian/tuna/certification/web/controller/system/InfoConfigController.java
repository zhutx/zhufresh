package com.moredian.tuna.certification.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moredian.bee.common.utils.JsonUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.fishnet.org.enums.PoliceOrgLevel;
import com.moredian.fishnet.org.model.AreaInfo;
import com.moredian.fishnet.org.model.OrgInfo;
import com.moredian.fishnet.org.service.AreaService;
import com.moredian.fishnet.org.service.OrgService;
import com.moredian.tuna.certification.model.SessionUser;
import com.moredian.tuna.certification.web.controller.BaseController;
import com.moredian.tuna.certification.web.controller.system.request.EditConfigInfoModel;
import com.moredian.tuna.certification.web.controller.system.response.AreaExtendsInfo;
import com.moredian.tuna.certification.web.controller.system.response.AuthOrgCountModel;
import com.moredian.tuna.certification.web.controller.system.response.ConfigInfoData;
import com.moredian.tuna.certification.web.controller.system.response.PaginationConfigInfoData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="InfoConfig API", description = "信息配置接口")
@RequestMapping("/infoConfig")
public class InfoConfigController extends BaseController {
	
	@SI
	private AreaService areaService;
	@SI
	private OrgService orgService;
	
	
	private List<ConfigInfoData> buildConfigInfoDataList(Integer areaCode, Integer areaLevel) {
		List<ConfigInfoData> list = new ArrayList<>();
		
		ConfigInfoData item = new ConfigInfoData();
		item.setAreaCode(areaCode);
		AreaInfo areaInfo = areaService.getAreaByCode(areaCode);
		item.setAreaName(areaInfo.getAreaName());
		
		String extendsInfo = areaInfo.getExtendsInfo();
		if(StringUtils.isNotBlank(extendsInfo)) {
			AreaExtendsInfo areaExtendInfo = JsonUtils.fromJson(AreaExtendsInfo.class, extendsInfo);
			if(areaExtendInfo != null) {
				item.setHotels(areaExtendInfo.getAuthOrgCount().getHotels());
				item.setBars(areaExtendInfo.getAuthOrgCount().getBars());
				item.setContact(areaExtendInfo.getAuthOrgCount().getContact());
				item.setPhone(areaExtendInfo.getAuthOrgCount().getPhone());
			}
		}
		
		list.add(item);
		
		return list;
	}
	
	private List<ConfigInfoData> buildConfigInfoDataList(Integer areaCode) {
		List<ConfigInfoData> list = new ArrayList<>();
		
		List<AreaInfo> children = areaService.findChildren(areaCode);
		if(CollectionUtils.isEmpty(children)) return list;
		
		for(AreaInfo areaInfo : children) {
			ConfigInfoData item = new ConfigInfoData();
			item.setAreaCode(areaInfo.getAreaCode());
			item.setAreaName(areaInfo.getAreaName());
			
			String extendsInfo = areaInfo.getExtendsInfo();
			if(StringUtils.isNotBlank(extendsInfo)) {
				AreaExtendsInfo areaExtendInfo = JsonUtils.fromJson(AreaExtendsInfo.class, extendsInfo);
				if(areaExtendInfo != null) {
					item.setContact(areaExtendInfo.getAuthOrgCount().getContact());
					item.setPhone(areaExtendInfo.getAuthOrgCount().getPhone());
					item.setHotels(areaExtendInfo.getAuthOrgCount().getHotels());
					item.setBars(areaExtendInfo.getAuthOrgCount().getBars());
				}
			}
			
			
			item.setChildren(this.buildConfigInfoDataList(areaInfo.getAreaCode()));
			
			list.add(item);
		}
		
		return list;
	}
	
	@ApiOperation(value="查询辖区信息配置", notes="查询辖区信息配置")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse list(@RequestParam(value = "orgId")Long orgId, @RequestParam(value = "bizOrgId", required = false)Long bizOrgId, @RequestParam(value = "pageNo")Integer pageNo, HttpServletRequest request) {
		
		SessionUser sessionUser = this.getSessionUser(request);
		orgId = sessionUser.getOrgId();
		
		BaseResponse<PaginationConfigInfoData> bdr = new BaseResponse<>();
		
		Integer provCode = sessionUser.getProvCode(); 
		Integer provAreaLevel = 1;
		Integer cityCode = sessionUser.getCityCode(); 
		Integer cityAreaLevel = 2;
		
		boolean provPoliceLogin = false;
		OrgInfo loginOrg = orgService.getOrgInfo(orgId);
		if(loginOrg.getOrgLevel() == PoliceOrgLevel.PROV.getValue()) {
			provPoliceLogin = true;
		}
		
		List<Integer> cityCodeList = new ArrayList<>();
		if(provPoliceLogin) { // 省厅登录
			if(bizOrgId == null) { // 没有选择任何市
				cityCodeList = areaService.findChildrenCode(provCode);
				cityCode = cityCodeList.get(pageNo - 1);
			} else { // 选择了某市
				OrgInfo orgInfo = orgService.getOrgInfo(bizOrgId);
				cityCodeList.add(orgInfo.getCityId());
				cityCode = orgInfo.getCityId();
			}
			
		} else { // 其他下级辖区登录
			cityCodeList.add(cityCode);
		}
		
		List<ConfigInfoData> provDataList = this.buildConfigInfoDataList(provCode, provAreaLevel);
		List<ConfigInfoData> cityDataList = this.buildConfigInfoDataList(cityCode, cityAreaLevel);
		
		for(ConfigInfoData data : cityDataList) {
			data.setChildren(this.buildConfigInfoDataList(data.getAreaCode()));
		}
				
		provDataList.get(0).setChildren(cityDataList);
		
		PaginationConfigInfoData pagination = new PaginationConfigInfoData();
		pagination.setPageNo(pageNo);
		pagination.setTotalCount(cityCodeList.size());
		pagination.setInfos(provDataList);
		
		bdr.setData(pagination);
		
		return bdr;
    }
	
	@ApiOperation(value="配置辖区信息", notes="配置辖区信息")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/edit", method=RequestMethod.PUT)
	@ResponseBody
    public BaseResponse edit(@RequestBody EditConfigInfoModel model) {
		
		// 街道只能修改自己 TODO
		// 区可以修改下辖街道 TODO
		
		AreaInfo areaInfo = areaService.getAreaByCode(model.getAreaCode());
		
		AreaExtendsInfo areaExtendInfo = new AreaExtendsInfo();
		AuthOrgCountModel m = new AuthOrgCountModel();
		m.setContact(model.getContact());
		m.setPhone(model.getPhone());
		m.setHotels(model.getHotels());
		m.setBars(model.getBars());
		areaExtendInfo.setAuthOrgCount(m);
		areaService.updateExtendsInfo(areaInfo.getAreaId(), JsonUtils.toJson(areaExtendInfo));
		
		return new BaseResponse();
    }

}
