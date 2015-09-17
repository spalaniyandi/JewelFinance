package com.finance.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RECEIPTS")
public class Receipt implements Serializable {
	
	private static final long serialVersionUID = 3616013794369054055L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RECEIPT_ID")
	private Long id;
	
	@Column(name="LOAN_AMOUNT", nullable = false)
	private Double loanAmount;
	
	@Column(name="LOAN_DATE")
	private Date loanDate;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
	private Address adddress;
	
	@ManyToOne
	@JoinColumn(name = "PHONE_ID", referencedColumnName = "PHONE_ID")
	private Phone phone;
	
	@OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Items> items = new HashSet<Items>();
	
	@Column(name="TOTAL_QTY")
	private Integer totoalQty;
	
	@Column(name="KILLOGRAM")
	private Float killogram;
	
	@Column(name="GRAM")
	private Float gram;
	
	@Column(name="MILLIGRAM")
	private Float milligram;
	
	@Column(name="RETURN_DATE")
	private Date returnDate;
	
	@ManyToOne
	@JoinColumn(name = "IDCARD_ID")
	private IDCard idCard;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DT")
	private Date createdDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATED_DT")
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAdddress() {
		return adddress;
	}

	public void setAdddress(Address adddress) {
		this.adddress = adddress;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

	public Integer getTotoalQty() {
		return totoalQty;
	}

	public void setTotoalQty(Integer totoalQty) {
		this.totoalQty = totoalQty;
	}

	public Float getKillogram() {
		return killogram;
	}

	public void setKillogram(Float killogram) {
		this.killogram = killogram;
	}

	public Float getGram() {
		return gram;
	}

	public void setGram(Float gram) {
		this.gram = gram;
	}

	public Float getMilligram() {
		return milligram;
	}

	public void setMilligram(Float milligram) {
		this.milligram = milligram;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public IDCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public void addItem(Items item) {
		this.getItems().add(item);
	}

	@Override
	public String toString() {
		return "Receipt [id=" + id + ", loanAmount=" + loanAmount
				+ ", loanDate=" + loanDate + ", customer=" + customer
				+ ", adddress=" + adddress + ", phone=" + phone + ", items="
				+ items + ", totoalQty=" + totoalQty + ", killogram="
				+ killogram + ", gram=" + gram + ", milligram=" + milligram
				+ ", returnDate=" + returnDate + ", idCard=" + idCard
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ "]";
	}

}
