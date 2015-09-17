package com.finance.web.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class ReceiptModel implements Serializable {
	
	private static final long serialVersionUID = -4329232210822841662L;
	
	private long receiptId;

	private boolean isGold;
	
	@NotNull
	private double loanAmount = 0;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@NotNull
	private Date loanDate;
	
	@Size(min=1, max=20)
	private String firstName;
	
	@Size(min=1, max=20)
	private String lastName;
	
	@Size(min=1, max=20)
	private String guardianName;
	
	@Valid
	private AddressModel address;
	
	private PhoneModel phone;
	
	// TODO List<ItemDetails>
	
	@Min(1)
	private int totalQty;
	
	private List<ItemModel> items = null;
	
	private WeightModel weight;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@NotNull
	private Date returnDate;
	
	private IDCardModel idCard;
	
	public ReceiptModel() {
		items = new ArrayList<ItemModel>();
		for (int i=0; i<5; i++) {
			items.add(new ItemModel());
		}
		/*items = LazyList.decorate(new ArrayList(), 
				FactoryUtils.instantiateFactory(ItemModel.class));
		ItemModel itemModel1 = new ItemModel();
		itemModel1.setItemName(" ");
		itemModel1.setItemQty(1);
		items.add(itemModel1);
		ItemModel itemModel2 = new ItemModel();
		itemModel2.setItemName(" ");
		itemModel2.setItemQty(1);
		items.add(itemModel2);*/
	}

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public boolean isGold() {
		return isGold;
	}

	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

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

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public WeightModel getWeight() {
		return weight;
	}

	public void setWeight(WeightModel weight) {
		this.weight = weight;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public IDCardModel getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCardModel idCard) {
		this.idCard = idCard;
	}

	public List<ItemModel> getItems() {
		return items;
	}

	public void setItems(List<ItemModel> items) {
		this.items = items;
	}
}
