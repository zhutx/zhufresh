package com.moredian.tuna.certification.web.controller.place.response;

import java.util.List;

import com.moredian.tuna.certification.model.PageData;

public class PaginationAuthCollData extends PageData {
	
	private List<AuthCollData> infos;

	public List<AuthCollData> getInfos() {
		return infos;
	}

	public void setInfos(List<AuthCollData> infos) {
		this.infos = infos;
	}

}
