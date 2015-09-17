package com.finance.service.mapper;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.finance.core.entity.Address;
import com.finance.core.entity.Customer;
import com.finance.core.entity.IDCard;
import com.finance.core.entity.Items;
import com.finance.core.entity.Phone;
import com.finance.core.entity.Receipt;
import com.finance.web.domain.AddressModel;
import com.finance.web.domain.IDCardModel;
import com.finance.web.domain.IDType;
import com.finance.web.domain.ItemModel;
import com.finance.web.domain.PhoneModel;
import com.finance.web.domain.PhoneType;
import com.finance.web.domain.ReceiptModel;
import com.finance.web.domain.WeightModel;

@Component
public class ReceiptMapper {
	
	public Receipt mapReceipt(ReceiptModel receiptModel, Customer customer) {
		
		Receipt receipt = new Receipt();
		receipt.setLoanAmount(receiptModel.getLoanAmount());
		receipt.setLoanDate(receiptModel.getLoanDate());
		receipt.setCustomer(customer);
		for (Address address : customer.getAddresses()) {
			receipt.setAdddress(address);
			break;
		}
		for (Phone phone : customer.getPhones()) {
			receipt.setPhone(phone);
			break;
		}
		for (ItemModel itemModel : receiptModel.getItems()) {
			if (itemModel.getItemName() != null && !itemModel.getItemName().isEmpty()) {
				Items item = new Items();
				item.setItemName(itemModel.getItemName());
				item.setItemQty(itemModel.getItemQty());
				item.setCreatedDate(new Date());
				receipt.addItem(item);
			}
		}
		receipt.setTotoalQty(receiptModel.getTotalQty());
		receipt.setKillogram(receiptModel.getWeight().getKilogram());
		receipt.setGram(receiptModel.getWeight().getGram());
		receipt.setMilligram(receiptModel.getWeight().getMilligram());
		receipt.setReturnDate(receiptModel.getReturnDate());
		for (IDCard idCard : customer.getIdCards()) {
			receipt.setIdCard(idCard);
			break;
		}
		receipt.setCreatedDate(new Date());
		
		return receipt;
	}
	
	public ReceiptModel mapReceiptModel(Receipt receipt) {
		
		ReceiptModel receiptModel = new ReceiptModel();
		receiptModel.setReceiptId(receipt.getId());
		receiptModel.setLoanAmount(receipt.getLoanAmount());
		receiptModel.setLoanDate(receipt.getLoanDate());
		
		Customer customer = receipt.getCustomer();
		receiptModel.setFirstName(customer.getFirstName());
		receiptModel.setLastName(customer.getLastName());
		receiptModel.setGuardianName(customer.getGuardianName());
		
		Address address = receipt.getAdddress();
		AddressModel addressModel = new AddressModel();
		addressModel.setStreet(address.getStreet());
		addressModel.setStreet2(address.getStreet2());
		addressModel.setCity(address.getCity());
		addressModel.setState(address.getState());
		addressModel.setPincode(address.getPincode());
		addressModel.setCountry(address.getCountry());
		receiptModel.setAddress(addressModel);
		
		Phone phone = receipt.getPhone();
		PhoneModel phoneModel = new PhoneModel();
		phoneModel.setPhoneTypes(PhoneType.valueOf(phone.getPhoneType()));
		phoneModel.setPhoneNumber(phone.getPhoneNumber());
		receiptModel.setPhone(phoneModel);
		
		WeightModel weightModel = new WeightModel();
		weightModel.setKilogram(receipt.getKillogram());
		weightModel.setGram(receipt.getGram());
		weightModel.setMilligram(receipt.getMilligram());
		receiptModel.setWeight(weightModel);
		
		receiptModel.setReturnDate(receipt.getReturnDate());
		
		IDCard idCard = receipt.getIdCard();
		IDCardModel idCardModel = new IDCardModel();
		idCardModel.setIdTypes(IDType.valueOf(idCard.getIdType()));
		idCardModel.setIdNumber(idCard.getIdNumber());
		receiptModel.setIdCard(idCardModel);
		
		return receiptModel;
	}
}
