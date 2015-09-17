package com.finance.core.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.finance.core.dao.CustomerDAO;
import com.finance.core.entity.Address;
import com.finance.core.entity.Customer;
import com.finance.core.entity.IDCard;
import com.finance.core.entity.Phone;
import com.finance.core.entity.SureshTab;

@Repository
public class CustomerDAOImpl extends AbstractDAOImpl implements CustomerDAO {

	@Override
	public void addCustomer(Customer customer) {
		Customer customer1 = makeCustomer();
		this.sessionFactory.getCurrentSession().persist(customer1);
	}
	
	private Customer makeCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("suresh");
		customer.setLastName("Palaniandy");
		customer.setGuardianName("palaniandy");
		customer.setCreatedBy("user");
		customer.setCreatedDate(new Date());
		Address address = new Address();
		address.setStreet("51,");
		address.setStreet2("walaja road");
		address.setCity("trichy");
		address.setState("Tamil Nadu");
		address.setCountry("IN");
		address.setCreatedBy("user");
		address.setCreatedDate(new Date());
		customer.addAddress(address);
		Phone phone = new Phone();
		phone.setPhoneType("mobile");
		phone.setPhoneNumber("985656");
		customer.addPhone(phone);
		IDCard idCard = new IDCard();
		idCard.setIdType("voter");
		idCard.setIdNumber("1234");
		//idCard.setCustomer(customer);
		customer.addIDCard(idCard);
		return customer;
	}

	@Override
	public Customer loadCustomer(long customerId) {
		return (Customer) this.sessionFactory.getCurrentSession().get(Customer.class, new Long(customerId));
	}

	@Override
	public List<Customer> loadCustomerByFirstName(String firstName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customers = (List<Customer>) session
				.createQuery(
						"from Customer as cus join cus.idCards idcs where cus.firstName = ?")
				.setString(0, firstName)
				.list();
		return customers;
	}
	
}
