package com.moredian.tuna.certification.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.ByteArrayFacePicture;
import com.moredian.bee.common.utils.ExceptionUtils;
import com.moredian.bee.common.utils.FacePicture;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.utils.RandomUtil;
import com.moredian.bee.filemanager.ImageFileManager;
import com.moredian.bee.filemanager.enums.FilePathType;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.rmq.EventBus;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.cloudeye.core.api.rs.RecognizeQueryService;
import com.moredian.cloudeye.core.api.rs.request.MatchRequest;
import com.moredian.cloudeye.core.api.rs.response.MatchResponse;
import com.moredian.fishnet.common.model.msg.AuthRecordMsg;
import com.moredian.fishnet.device.model.DeviceInfo;
import com.moredian.fishnet.device.service.DeviceService;
import com.moredian.fishnet.org.enums.PoliceOrgLevel;
import com.moredian.fishnet.org.model.OrgInfo;
import com.moredian.fishnet.org.service.OrgService;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.tuna.certification.config.AuthProperties;
import com.moredian.tuna.certification.domain.AuthRecord;
import com.moredian.tuna.certification.domain.AuthRecordQueryCondition;
import com.moredian.tuna.certification.enums.AuthStatus;
import com.moredian.tuna.certification.enums.AuthWay;
import com.moredian.tuna.certification.enums.CertificationErrorCode;
import com.moredian.tuna.certification.enums.PersonNature;
import com.moredian.tuna.certification.enums.PersonSex;
import com.moredian.tuna.certification.enums.YesNoFlag;
import com.moredian.tuna.certification.manager.AuthManager;
import com.moredian.tuna.certification.mapper.AuthRecordMapper;
import com.moredian.tuna.certification.model.AuthRecordInfo;
import com.moredian.tuna.certification.request.AuthRecordSearchRequest;
import com.moredian.tuna.certification.request.InputCertNoRequest;
import com.moredian.tuna.certification.request.NormalAuthRequest;

@Service
public class AuthManagerImpl implements AuthManager {
	
	@Autowired
	private AuthRecordMapper authRecordMapper;
	@SI
	private RecognizeQueryService recognizeQueryService;
	@Autowired
	private AuthProperties authProperties;
	@SI
	private IdgeneratorService idgeneratorService;
	@SI
	private DeviceService deviceService;
	@SI
	private OrgService orgService;
	@Autowired
	private ImageFileManager imageFileManager;
	
	private Long genPrimaryKey(String typeName) {
		return idgeneratorService.getNextIdByTypeName(typeName).getData();
	}
	
	private MatchResponse doCloudeyeMatch(NormalAuthRequest request) {
		MatchRequest matchRequest = new MatchRequest();
		FacePicture matchImage = new ByteArrayFacePicture(request.getCatchImage());
		FacePicture beComparedImage = new ByteArrayFacePicture(request.getCertImage());
		matchRequest.setMatchImage(matchImage);
		matchRequest.setBeComparedImage(beComparedImage);
		matchRequest.setMatchConfidence(authProperties.getThreshold());
		ServiceResponse<MatchResponse> sr = recognizeQueryService.matchFace(matchRequest);
		if(!sr.isSuccess()) sr.pickDataThrowException();
		return sr.getData();
	}
	
	private String storeImage(byte[] image, FilePathType filePathType) {
		
		Map<String, Object> map = null;
		String fileName = RandomUtil.getUUID() + ".jpg";
		try {
			map = imageFileManager.saveImage(image, filePathType, fileName);
		} catch (Exception e) {
			ExceptionUtils.throwException(CertificationErrorCode.SAVE_IMAGE_ERROR, CertificationErrorCode.SAVE_IMAGE_ERROR.getMessage());
		}
		if(!"0".equals(map.get("result"))) {
			ExceptionUtils.throwException(CertificationErrorCode.SAVE_IMAGE_WRONG, CertificationErrorCode.SAVE_IMAGE_WRONG.getMessage());
		}
		
		return (String)map.get("url");
		
	}
	
	private AuthRecord buildAuthRecord(NormalAuthRequest request, MatchResponse matchResponse) {
		DeviceInfo device = deviceService.getDeviceBySn(request.getDeviceSn());
		OrgInfo org = orgService.getOrgInfo(device.getOrgId());
		
		AuthRecord authRecord = new AuthRecord();
		authRecord.setAuthRecordId(this.genPrimaryKey(AuthRecord.class.getName()));
		authRecord.setAuthWay(AuthWay.FACE_MATCH.getValue());
		authRecord.setCatchImageUrl(this.storeImage(request.getCatchImage(), FilePathType.TYPE_MEMBERFACEIMAGE));
		authRecord.setMatchImageUrl(this.storeImage(request.getCertImage(), FilePathType.TYPE_MEMBERFACEIMAGE));
		authRecord.setDeviceId(device.getDeviceId());
		authRecord.setDeviceSn(device.getDeviceSn());
		authRecord.setOrgType(org.getOrgType());
		authRecord.setOrgId(org.getOrgId());
		authRecord.setOrgName(org.getOrgName());
		authRecord.setProvinceCode(org.getProvinceId());
		authRecord.setCityCode(org.getCityId());
		authRecord.setDistrictCode(org.getDistrictId());
		authRecord.setTownCode(org.getTownId());
		authRecord.setOrgAddress(org.getAddress());
		authRecord.setAuthTime(System.currentTimeMillis());
		//authRecord.setQuality(null);
		authRecord.setConfidence(matchResponse.getConfidence());
		
		// 3303***1415/朱**/男/19861014/汉/浙江省***１６号/20101008-20201008/***公安局
		String certRemark = request.getCertInfo();
		String[] arr = certRemark.split("/");
		authRecord.setCertNo(arr[0]);
		authRecord.setRealName(arr[1]);
		authRecord.setSex(PersonSex.getValue(arr[2]));
		authRecord.setBirthday(arr[3]);
		authRecord.setNature(PersonNature.getValue(arr[4]));
		authRecord.setAddress(arr[5]);
		authRecord.setSignOrg(arr[7]);
		
		String[] validDate = arr[6].split("-");
		authRecord.setValidBeginDate(validDate[0].replaceAll(".", ""));
		authRecord.setValidEndDate(validDate[1].replaceAll(".", ""));
		
		List<OrgInfo> monitorPoliceOrgList = orgService.findMonitorPoliceOrg(org.getTownId());
		for(OrgInfo policeOrg : monitorPoliceOrgList) {
			if(policeOrg.getOrgLevel() == PoliceOrgLevel.PROV.getValue()) { // 省厅
				authRecord.setProvPoliceOrgId(policeOrg.getOrgId());
				authRecord.setProvPoliceOrgName(policeOrg.getOrgName());
			}
			if(policeOrg.getOrgLevel() == PoliceOrgLevel.CITY.getValue()) { // 市局
				authRecord.setCityPoliceOrgId(policeOrg.getOrgId());
				authRecord.setCityPoliceOrgName(policeOrg.getOrgName());
			}
			if(policeOrg.getOrgLevel() == PoliceOrgLevel.DISTRICT.getValue()) { // 分局
				authRecord.setDistrictPoliceOrgId(policeOrg.getOrgId());
				authRecord.setDistrictPoliceOrgName(policeOrg.getOrgName());
			}
			if(policeOrg.getOrgLevel() == PoliceOrgLevel.TOWN.getValue()) { // 街道派出所
				authRecord.setTownPoliceOrgId(policeOrg.getOrgId());
				authRecord.setTownPoliceOrgName(policeOrg.getOrgName());
			}
		}
		authRecord.setTriggerAlarmFlag(YesNoFlag.NO.getValue());
		int status = matchResponse.isMatch() ? AuthStatus.SUCC.getValue() : AuthStatus.FAIL.getValue();
		authRecord.setStatus(status);
		
		return authRecord;
	}
	
	@Override
	public Long auth(NormalAuthRequest request) {
		
		BizAssert.notBlank(request.getDeviceSn());
		BizAssert.notNull(request.getCatchImage());
		BizAssert.notNull(request.getCertImage());
		BizAssert.notBlank(request.getCertInfo());
		
		// 1) 云眼对比
		MatchResponse matchResponse = this.doCloudeyeMatch(request);
		
		// 2) 认证入库
		AuthRecord authRecord = this.buildAuthRecord(request, matchResponse);
		authRecordMapper.insert(authRecord);
		
		// 3) 发布认证消息
		AuthRecordMsg msg = BeanUtils.copyProperties(AuthRecordMsg.class, authRecord);
		EventBus.publish(msg);
		
		return authRecord.getAuthRecordId();
	}
	
	@Override
	public Long auth(InputCertNoRequest request) {
		
		BizAssert.notBlank(request.getDeviceSn());
		BizAssert.notNull(request.getCatchImage());
		BizAssert.notBlank(request.getCertNo());
		
		// TODO 手输身份证认证
		
		return null;
	}

	public AuthRecordQueryCondition authRecordQueryRequestToAuthRecordQueryCondition(AuthRecordSearchRequest request) {
		return BeanUtils.copyProperties(AuthRecordQueryCondition.class, request);
	}
	
	public PaginationDomain<AuthRecord> paginationAuthRecordInfoToPaginationAuthRecord(Pagination<AuthRecordInfo> fromPagination) {
		return PaginationConvertor.paginationToPaginationDomain(fromPagination, new PaginationDomain<AuthRecord>());
	}

	@SuppressWarnings("unchecked")
	@Override
	public PaginationDomain<AuthRecord> findAuthRecord(Pagination<AuthRecordInfo> pagination,
			AuthRecordSearchRequest request) {
		AuthRecordQueryCondition queryCondition = authRecordQueryRequestToAuthRecordQueryCondition(request);
		PaginationDomain<AuthRecord> paginationAuthRecord = paginationAuthRecordInfoToPaginationAuthRecord(pagination);
		
		return this.getPagination(paginationAuthRecord, queryCondition);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected PaginationDomain getPagination(PaginationDomain pagination, AuthRecordQueryCondition queryCondition) {
        int totalCount = (Integer) authRecordMapper.getTotalCountByCondition(queryCondition);
        pagination.setTotalCount(totalCount);
        if (totalCount > 0) {
        	queryCondition.setStartRow(pagination.getStartRow());
        	queryCondition.setPageSize(pagination.getPageSize());
        	pagination.setData(authRecordMapper.findPaginationByCondition(queryCondition));
        }
        return pagination;
    }

	@Override
	public AuthRecord getAuth(Long authRecordId) {
		return authRecordMapper.load(authRecordId);
	}

}
