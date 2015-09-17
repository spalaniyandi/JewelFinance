package com.finance.service.mapper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finance.core.entity.Address;
import com.finance.core.entity.Customer;
import com.finance.core.entity.IDCard;
import com.finance.core.entity.Phone;
import com.finance.web.domain.AddressModel;
import com.finance.web.domain.IDCardModel;
import com.finance.web.domain.IDType;
import com.finance.web.domain.PhoneModel;
import com.finance.web.domain.PhoneType;
import com.finance.web.domain.ReceiptModel;

@Component
public class CustomerMapper {
	
	public Customer mapCustomer(ReceiptModel receipt) {
		
		Customer customer = new Customer();
		
		customer.setFirstName(receipt.getFirstName());
		customer.setLastName(receipt.getLastName());
		customer.setGuardianName(receipt.getGuardianName());
		
		Address address = constructAddress(receipt.getAddress());
		customer.addAddress(address);
		
		Phone phone = constructPhone(receipt.getPhone());
		customer.addPhone(phone);
		
		IDCard idCard = constructIDCard(receipt.getIdCard());
		customer.addIDCard(idCard);
		
		customer.setCreatedDate(new Date());
		
		return customer;
	}
	
	private IDCard constructIDCard(IDCardModel idCardModel) {
		
		IDCard idCard = new IDCard();
		idCard.setIdType(idCardModel.getIdTypes().toString());
		idCard.setIdNumber(idCardModel.getIdNumber());
		idCard.setCreatedDate(new Date());
		return idCard;
	}

	private Phone constructPhone(PhoneModel phoneModel) {
		
		Phone phone = new Phone();
		phone.setPhoneType(phoneModel.getPhoneTypes().toString());
		phone.setPhoneNumber(phoneModel.getPhoneNumber());
		phone.setCreatedDate(new Date());
		return phone;
	}

	private Address constructAddress(AddressModel addressModel) {
		
		Address address = new Address();
		address.setStreet(addressModel.getStreet());
		address.setStreet2(address.getStreet2());
		address.setCity(addressModel.getCity());
		address.setPincode(addressModel.getPincode());
		address.setState(addressModel.getState());
		address.setCountry(addressModel.getCountry());
		address.setCreatedDate(new Date());
		return address;
	}
}
