package com.moredian.tuna.certification.web.controller.auth;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.JsonUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.filemanager.ImageFileManager;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.fishnet.org.enums.AreaLevel;
import com.moredian.fishnet.org.model.AreaInfo;
import com.moredian.fishnet.org.service.AreaService;
import com.moredian.fishnet.org.service.OrgService;
import com.moredian.tuna.certification.config.MyWebSocket;
import com.moredian.tuna.certification.model.AuthRecordInfo;
import com.moredian.tuna.certification.request.AuthRecordSearchRequest;
import com.moredian.tuna.certification.request.InputCertNoRequest;
import com.moredian.tuna.certification.request.NormalAuthRequest;
import com.moredian.tuna.certification.service.AuthService;
import com.moredian.tuna.certification.web.controller.BaseController;
import com.moredian.tuna.certification.web.controller.auth.request.AuthProcessModel;
import com.moredian.tuna.certification.web.controller.auth.response.AuthRecordData;
import com.moredian.tuna.certification.web.controller.auth.response.AuthResponse;
import com.moredian.tuna.certification.web.controller.auth.response.PaginationAuthRecordData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Auth API", description = "认证接口")
@RequestMapping("/auth")
public class AuthController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@SI
	private AreaService areaService;
	@SI
	private AuthService authService;
	@SI
	private OrgService orgService;
	@Autowired
	private ImageFileManager imageFileManager;
	
	private NormalAuthRequest buildNormalAuthRequest(AuthProcessModel model) {
		return BeanUtils.copyProperties(NormalAuthRequest.class, model);
	}
	
	private InputCertNoRequest buildInputCertNoRequest(AuthProcessModel model) {
		InputCertNoRequest request = new InputCertNoRequest();
		request.setDeviceSn(model.getDeviceSn());
		request.setCatchImage(model.getCatchImage());
		request.setCertNo(model.getInputCertNo());
		return request;
	}
	
	private void sendToSubscriber (String message) {
        for (MyWebSocket item : MyWebSocket.webSocketSet ){
            try {
				item.sendMessage(message);
			} catch (IOException e) {
				logger.info("识别记录websocket推送给订阅方异常");
			}
        }
    }
	
	public static byte[] multipartFile2byte(MultipartFile imgFile)  
            throws IOException {  
		InputStream inStream = imgFile.getInputStream();
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
        byte[] buff = new byte[100];  
        int rc = 0;  
        while ((rc = inStream.read(buff, 0, 100)) > 0) {  
            swapStream.write(buff, 0, rc);  
        }  
        byte[] in2b = swapStream.toByteArray();  
        return in2b;  
    }
	
	@ApiOperation(value="认证", notes="认证")
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value="/auth", method=RequestMethod.POST)
	@ResponseBody
    public BaseResponse auth(@RequestParam(value="certInfo") String certInfo, @RequestParam(value="deviceSn") String deviceSn, @RequestParam(value="catchImage") MultipartFile catchImage, @RequestParam(value="certImage") MultipartFile certImage) throws Exception {
		AuthProcessModel model = new AuthProcessModel();
		//FacePicture picture = new NetworkFacePicture("http://img.dev.moredian.com:8000/temporary/2017/8/21/17/cf628f662b2644c2a36b87c943e0b6fb.jpg");
		model.setCatchImage(catchImage.getBytes());
		model.setCertImage(certImage.getBytes());
		model.setDeviceSn(deviceSn);
		model.setCertInfo(certInfo);
		
		ServiceResponse<Long> sr = null;
		if(StringUtils.isBlank(model.getInputCertNo())) { // 非手输身份证号
			sr = authService.normalAuth(this.buildNormalAuthRequest(model)); // 芯片照、抓拍照对比认证
			if(!sr.isSuccess()) {
				sr.pickDataThrowException();
			}
		} else {
			sr = authService.inputCertNoAuth(this.buildInputCertNoRequest(model)); // 手输身份证号认证
			if(!sr.isSuccess()) {
				sr.pickDataThrowException();
			}
		}
		
		AuthRecordInfo authRecord = authService.getAuth(sr.getData());
		AuthRecordData recordData = this.buildAuthRecordData(authRecord);
		this.sendToSubscriber(JsonUtils.toJson(recordData));
		
		AuthResponse response = this.buildAuthResponse(authRecord);
		BaseResponse<AuthResponse> br = new BaseResponse<>();
		br.setData(response);
		return br;
	}
	
	private Pagination<AuthRecordInfo> buildPagination(int pageNo, int pageSize) {
		Pagination<AuthRecordInfo> pagination = new Pagination<>();
		pagination.setPageNo(pageNo);
		pagination.setPageSize(pageSize);
		return pagination;
	}
	
	private AuthRecordSearchRequest buildRequest(Integer provCode, Integer cityCode, Integer districtCode, Integer townCode, Integer orgType, Integer status, Integer authWay, String certNo, Integer triggerAlarmFlag, String beginDate, String endDate, String orgName, Long deviceId) {
		AuthRecordSearchRequest request = new AuthRecordSearchRequest();
		request.setProvCode(provCode);
		request.setCityCode(cityCode);
		request.setDistrictCode(districtCode);
		request.setTownCode(townCode);
		request.setOrgType(orgType);
		request.setStatus(status);
		request.setAuthWay(authWay);
		request.setCertNo(certNo);
		request.setTriggerAlarmFlag(triggerAlarmFlag);
		try {
			request.setBeginDate(new SimpleDateFormat("yyyy-MM-dd").parse(beginDate));
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1);
			request.setEndDate(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		request.setOrgName(orgName);
		request.setDeviceId(deviceId);
		return request;
	}
	
	private List<AuthRecordData> buildAuthRecordDataList(List<AuthRecordInfo> authRecordInfoList) {
		List<AuthRecordData> authRecordDataList = new ArrayList<>();
		if(CollectionUtils.isEmpty(authRecordInfoList)) return authRecordDataList;
		for(AuthRecordInfo authRecordInfo : authRecordInfoList) {
			AuthRecordData item = BeanUtils.copyProperties(AuthRecordData.class, authRecordInfo);
			item.setCatchImageUrl(imageFileManager.getImageUrl(item.getCatchImageUrl()));
			item.setMatchImageUrl(imageFileManager.getImageUrl(item.getMatchImageUrl()));
			authRecordDataList.add(item);
			
		}
		return authRecordDataList;
	}
	
	private PaginationAuthRecordData buildPaginationAuthRecordData(Pagination<AuthRecordInfo> pagination) {
		PaginationAuthRecordData data = new PaginationAuthRecordData();
		data.setPageNo(pagination.getPageNo());
		data.setTotalCount(pagination.getTotalCount());
		List<AuthRecordData> records = this.buildAuthRecordDataList(pagination.getData());
		data.setRecords(records);
		return data;
	}
	
	private AuthRecordData buildAuthRecordData(AuthRecordInfo authRecordInfo) {
		AuthRecordData data = BeanUtils.copyProperties(AuthRecordData.class, authRecordInfo);
		data.setCatchImageUrl(imageFileManager.getImageUrl(authRecordInfo.getCatchImageUrl()));
		data.setMatchImageUrl(imageFileManager.getImageUrl(authRecordInfo.getMatchImageUrl()));
		return data;
	}
	
	private AuthResponse buildAuthResponse(AuthRecordInfo authRecordInfo) {
		AuthResponse data = BeanUtils.copyProperties(AuthResponse.class, authRecordInfo);
		data.setCatchImageUrl(imageFileManager.getImageUrl(authRecordInfo.getCatchImageUrl()));
		data.setMatchImageUrl(imageFileManager.getImageUrl(authRecordInfo.getMatchImageUrl()));
		return data;
	}
	
	@ApiOperation(value="查询认证记录", notes="查询认证记录")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse list(@RequestParam(value = "orgId", required = false)Long orgId, @RequestParam(value = "bizAreaCode")Integer bizAreaCode, @RequestParam(value = "beginDate") String beginDate, @RequestParam(value = "endDate") String endDate, @RequestParam(value = "pageNo") Integer pageNo, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "searchAreaCode", required = false) Integer searchAreaCode, @RequestParam(value = "orgType", required = false) Integer orgType, @RequestParam(value = "status", required = false) Integer status, @RequestParam(value = "authWay", required = false) Integer authWay, @RequestParam(value = "certNo", required = false) String certNo, @RequestParam(value = "triggerAlarmFlag", required = false) Integer triggerAlarmFlag, @RequestParam(value = "orgName", required = false) String orgName, @RequestParam(value = "deviceId", required = false) Long deviceId, HttpServletRequest request) {
		
		BaseResponse<PaginationAuthRecordData> bdr = new BaseResponse<>();
		
		/*SessionUser sessionUser = this.getSessionUser(request); TODO
		
		orgId = sessionUser.getOrgId();
		
		Integer provCode = sessionUser.getProvCode();*/
		Integer provCode = 330000;
		Integer cityCode = null;
		Integer districtCode = null;
		Integer townCode = null;
		
		AreaInfo area = areaService.getAreaByCode(bizAreaCode);
		if(area.getAreaLevel() == AreaLevel.PROV.getValue()) {
			cityCode = searchAreaCode;
		}
		if(area.getAreaLevel() == AreaLevel.CITY.getValue()) {
			districtCode = searchAreaCode;
		}
		if(area.getAreaLevel() == AreaLevel.DISTRICT.getValue()) {
			townCode = searchAreaCode;
		}
		if(area.getAreaLevel() == AreaLevel.TOWN.getValue()) {
			townCode = searchAreaCode;
		}
		
		Pagination<AuthRecordInfo> pagination = authService.findAuthRecord(this.buildPagination(pageNo, pageSize), this.buildRequest(provCode, cityCode, districtCode, townCode, orgType, status, authWay, certNo, triggerAlarmFlag, beginDate, endDate, orgName, deviceId));
		
		bdr.setData(this.buildPaginationAuthRecordData(pagination));
		
		return bdr;
    }
	
	private AuthRecordSearchRequest buildRequest(String certNo) {
		AuthRecordSearchRequest request = new AuthRecordSearchRequest();
		request.setCertNo(certNo);
		return request;
	}
	
	@ApiOperation(value="查询认证记录", notes="查询认证记录")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/listByCertNo", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse listByCertNo(@RequestParam(value = "certNo")String certNo,  @RequestParam(value = "pageNo") Integer pageNo, @RequestParam(value = "pageSize") Integer pageSize, HttpServletRequest request) {
		
		BaseResponse<PaginationAuthRecordData> bdr = new BaseResponse<>();
		
		Pagination<AuthRecordInfo> pagination = authService.findAuthRecord(this.buildPagination(pageNo, pageSize), this.buildRequest(certNo));
		
		bdr.setData(this.buildPaginationAuthRecordData(pagination));
		
		return bdr;
    }
	
	@ApiOperation(value="查询认证详情", notes="查询认证详情")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	@ResponseBody
    public BaseResponse detail(@RequestParam(value = "authRecordId") Long authRecordId, HttpServletRequest request) {
		BaseResponse<AuthRecordData> bdr = new BaseResponse<>();
		AuthRecordInfo authRecordInfo = authService.getAuth(authRecordId);
		bdr.setData(this.buildAuthRecordData(authRecordInfo));
		return bdr;
    }
	

}
