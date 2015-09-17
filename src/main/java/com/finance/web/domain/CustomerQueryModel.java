package com.finance.web.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

public class CustomerQueryModel implements Serializable {
	
	private static final long serialVersionUID = 6855397707129092079L;

	@Size(min=1, max=20)
	private String firstName;
	
	@Size(min=1, max=20)
	private String lastName;
	
	@Size(min=1, max=20)
	private String guardianName;
	
	@Valid
	private AddressModel address;
	
	private PhoneModel phone;
	
	private IDCardModel idCard;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public PhoneModel getPhone() {
		return phone;
	}

	public void setPhone(PhoneModel phone) {
		this.phone = phone;
	}

	public IDCardModel getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCardModel idCard) {
		this.idCard = idCard;
	}
}
