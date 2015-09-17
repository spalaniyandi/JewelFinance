package com.finance.web.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneModel {
	
	private PhoneType phoneTypes;
	
	private String phoneNumber;
	
	public PhoneModel() {
	}
	
	public PhoneModel(PhoneType phoneType, String phoneNumber) {
		this.phoneTypes = phoneType;
		this.phoneNumber = phoneNumber;
	}

	public PhoneType getPhoneTypes() {
		return phoneTypes;
	}

	public void setPhoneTypes(PhoneType phoneTypes) {
		this.phoneTypes = phoneTypes;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneTypeInString() {
		return phoneTypes.toString();
	}
}
