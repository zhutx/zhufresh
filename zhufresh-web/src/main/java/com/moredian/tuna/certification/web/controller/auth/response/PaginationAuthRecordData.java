package com.moredian.tuna.certification.web.controller.auth.response;

import java.util.List;

import com.moredian.tuna.certification.model.PageData;

public class PaginationAuthRecordData extends PageData {
	
	private List<AuthRecordData> records;

	public List<AuthRecordData> getRecords() {
		return records;
	}

	public void setRecords(List<AuthRecordData> records) {
		this.records = records;
	}

}
