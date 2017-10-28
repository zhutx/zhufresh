package com.moredian.tuna.certification.web.controller.system.response;

import java.util.List;

import com.moredian.tuna.certification.model.PageData;

public class PaginationConfigInfoData extends PageData {
	
	private List<ConfigInfoData> infos;

	public List<ConfigInfoData> getInfos() {
		return infos;
	}

	public void setInfos(List<ConfigInfoData> infos) {
		this.infos = infos;
	}

}
