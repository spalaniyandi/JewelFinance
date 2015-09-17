package com.finance.web.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class IDCardModel {
	
	private IDType idTypes;
	
	private String idNumber;
	
	public IDCardModel() {
	}

	public IDType getIdTypes() {
		return idTypes;
	}

	public void setIdTypes(IDType idTypes) {
		this.idTypes = idTypes;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public String getIDTypeInString() {
		return idTypes.toString();
	}
}
