package com.moredian.tuna.certification.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.fishnet.auth.request.AdminInitRequest;
import com.moredian.fishnet.auth.request.OperAddRequest;
import com.moredian.fishnet.auth.service.OperService;
import com.moredian.fishnet.org.enums.OrgStatus;
import com.moredian.fishnet.org.enums.OrgType;
import com.moredian.fishnet.org.enums.PoliceOrgLevel;
import com.moredian.fishnet.org.model.AreaInfo;
import com.moredian.fishnet.org.model.OrgInfo;
import com.moredian.fishnet.org.request.OrgAddRequest;
import com.moredian.fishnet.org.service.AreaService;
import com.moredian.fishnet.org.service.OrgService;
import com.moredian.tuna.certification.web.controller.BaseController;
import com.moredian.tuna.certification.web.controller.system.request.AddOperModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Oper API", description = "账号接口")
@RequestMapping("/oper")
public class OperController extends BaseController {
	
	@SI
	private OperService operService;
	@SI
	private OrgService orgService;
	@SI
	private AreaService areaService;
	
	private OperAddRequest buildOperAddRequest(AddOperModel model) {
		OperAddRequest request = new OperAddRequest();
		request.setModuleType(model.getModuleType());
		request.setAccountName(model.getAccountName());
		request.setPassword(model.getPassword());
		request.setOperName(model.getOperName());
		request.setOperDesc(model.getOperDesc());
		request.setOrgId(model.getOrgId());
		request.setEmail(model.getEmail());
		request.setMobile(model.getMobile());
		
		List<Long> roleIds = new ArrayList<>();
		if(StringUtils.isNotBlank(model.getRoleIds())) {
			for(String str : model.getRoleIds().split(",")) {
				roleIds.add(Long.parseLong(str));
			}
		}
		request.setRoleIds(roleIds);
		return request;
	}
	
	@ApiOperation(value="添加账号", notes="添加账号")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
    public BaseResponse add(@RequestBody AddOperModel model, HttpServletRequest request) {
		
		model.setOrgId(this.getSessionUser(request).getOrgId());
		
		boolean addChild = false;
		Integer childProvCode = null;
		Integer childCityCode= null;
		Integer childDistrictCode = null;
		Integer childTownCode = null;
		OrgInfo orgInfo = orgService.getOrgInfo(model.getOrgId());
		String childOrgName = null;
		if(orgInfo.getOrgLevel() == PoliceOrgLevel.TOP.getValue()){ // 公安部
			if(model.getProvAreaCode() != null) { // 选择了省厅
				addChild = true;
				childProvCode = model.getProvAreaCode();
				AreaInfo area = areaService.getAreaByCode(childProvCode);
				childOrgName = area.getAreaName()+"公安厅";
			}
		} else if(orgInfo.getOrgLevel() == PoliceOrgLevel.PROV.getValue()){ // 省厅
			if(model.getCityAreaCode() != null) { // 选择了市局
				addChild = true;
				childProvCode = model.getProvAreaCode();
				childCityCode = model.getCityAreaCode();
				AreaInfo area = areaService.getAreaByCode(childCityCode);
				childOrgName = area.getAreaName()+"公安局";
			}
		} else if(orgInfo.getOrgLevel() == PoliceOrgLevel.CITY.getValue()){ // 市局
			if(model.getDistrictAreaCode() != null) { // 选择了分局
				addChild = true;
				childProvCode = model.getProvAreaCode();
				childCityCode = model.getCityAreaCode();
				childDistrictCode = model.getDistrictAreaCode();
				AreaInfo area = areaService.getAreaByCode(childDistrictCode);
				childOrgName = area.getAreaName()+"分局";
			}
		} else if(orgInfo.getOrgLevel() == PoliceOrgLevel.DISTRICT.getValue()){ // 分局
			if(model.getTownAreaCode() != null) { // 选择了街道
				addChild = true;
				childProvCode = model.getProvAreaCode();
				childCityCode = model.getCityAreaCode();
				childDistrictCode = model.getDistrictAreaCode();
				childTownCode = model.getTownAreaCode();
				AreaInfo area = areaService.getAreaByCode(childTownCode);
				childOrgName = area.getAreaName().replace("镇", "").replace("街道", "")+"派出所";
			}
		} 
		
		if(addChild) {
			Long childOrgId = null;
			OrgInfo childOrg = orgService.getOrgByName(childOrgName);
			if(childOrg == null) {
				OrgAddRequest orgAddRequest = new OrgAddRequest();
				orgAddRequest.setOrgName(childOrgName);
				orgAddRequest.setOrgType(OrgType.POLICE.getValue());
				orgAddRequest.setOrgLevel(orgInfo.getOrgLevel()+1);
				orgAddRequest.setStatus(OrgStatus.USABLE.getValue());
				orgAddRequest.setProvinceId(childProvCode);
				orgAddRequest.setCityId(childCityCode);
				orgAddRequest.setDistrictId(childDistrictCode);
				orgAddRequest.setTownId(childTownCode);
				orgAddRequest.setContact(model.getOperName());
				orgAddRequest.setPhone(model.getMobile());
				orgAddRequest.setParentOrgId(model.getOrgId());
				ServiceResponse<Long> sr = orgService.addOrg(orgAddRequest);
				if(!sr.isSuccess()) sr.pickDataThrowException();
				childOrgId = sr.getData();
			} else {
				childOrgId = childOrg.getOrgId();
			}
			
			AdminInitRequest adminInitRequest = BeanUtils.copyProperties(AdminInitRequest.class, model);
			adminInitRequest.setOrgId(childOrgId);
			operService.initOneAdmin(adminInitRequest).pickDataThrowException();
			
		} else {
			operService.addOper(this.buildOperAddRequest(model)).pickDataThrowException();
		}
		
		return new BaseResponse();
    }
	
	
}
