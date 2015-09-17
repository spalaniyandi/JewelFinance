package com.finance.web.domain;

import java.io.Serializable;
import java.util.Date;

public class ReceiptQueryModel implements Serializable {
	
	private static final long serialVersionUID = 5106066610776314752L;

	private long receiptId;
	
	private double loanAmount;
	
	private String firstName;
	
	private String lastName;
	
	private Date loanDate;
	
	private PhoneModel phone;
	
	private IDCardModel idCard;
	
	public ReceiptQueryModel() {
		
	}

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
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

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
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
