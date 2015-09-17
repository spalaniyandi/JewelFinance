package com.finance.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 9001752609929447766L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="GUARDIAN_NAME")
	private String guardianName;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="CUSTOMER_ADDRESS", joinColumns={ @JoinColumn(name="CUSTOMER_ID")},
			inverseJoinColumns={@JoinColumn(name="ADDRESS_ID")})
	private Set<Address> addresses = new HashSet<Address>();
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="CUSTOMER_PHONE", joinColumns={ @JoinColumn(name="CUSTOMER_ID")},
			inverseJoinColumns={@JoinColumn(name="PHONE_ID")})
	private Set<Phone> phones = new HashSet<Phone>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	private Set<IDCard> idCards = new HashSet<IDCard>();
	
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Set<IDCard> getIdCards() {
		return idCards;
	}

	public void setIdCards(Set<IDCard> idCards) {
		this.idCards = idCards;
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
	
	public void addAddress(Address address) {
		this.getAddresses().add(address);
	}
	
	public void addPhone(Phone phone) {
		this.getPhones().add(phone);
	}
	
	public void addIDCard(IDCard idCard) {
		this.getIdCards().add(idCard);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", guardianName=" + guardianName + ", addresses=" + addresses
				+ ", phones=" + phones + ", idCards=" + idCards
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ "]";
	}

}
