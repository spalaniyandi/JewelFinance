package com.finance.web.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

public class CustomerModel implements Serializable {
	
	private static final long serialVersionUID = 8633888106309434555L;
	
	@Size(min=1, max=20)
	private String firstName;
	
	@Size(min=1, max=20)
	private String lastName;
	
	@Size(min=1, max=20)
	private String guardianName;
	
	@Valid
	private AddressModel permenantAddress;
	
	@Valid
	private AddressModel presentAddress;
	
	private List<AddressModel> addresses;
	
	@Valid
	private List<PhoneModel> phones;
	
	@Valid
	private IDCardModel idCard;
	
	public CustomerModel() {
		phones = new ArrayList<PhoneModel>();
		phones.add(new PhoneModel(PhoneType.home, null));
		phones.add(new PhoneModel(PhoneType.mobile, null));
		phones.add(new PhoneModel(PhoneType.work, null));
	}

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getGuardianName() { return guardianName; }
	public void setGuardianName(String guardianName) { this.guardianName = guardianName; }

	public AddressModel getPermenantAddress() { return permenantAddress; }
	public void setPermenantAddress(AddressModel permenantAddress) {
		this.permenantAddress = permenantAddress;
	}
	
	public AddressModel getPresentAddress() { return presentAddress; }
	public void setPresentAddress(AddressModel presentAddress) {
		this.presentAddress = presentAddress;
	}

	public List<AddressModel> getAddresses() { return addresses; }
	public void setAddresses(List<AddressModel> addresses) { this.addresses = addresses;}

	public List<PhoneModel> getPhones() { return phones; }
	public void setPhones(List<PhoneModel> phones) { this.phones = phones; }

	public IDCardModel getIdCard() { return idCard; }
	public void setIdCard(IDCardModel idCard) { this.idCard = idCard; }
}
