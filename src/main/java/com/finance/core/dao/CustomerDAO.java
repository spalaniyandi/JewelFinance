package com.finance.core.dao;

import java.util.List;

import com.finance.core.entity.Customer;
import com.finance.core.entity.SureshTab;

public interface CustomerDAO {
	
	public void addCustomer(Customer customer);
	
	public Customer loadCustomer(long customerId);

	public List<Customer> loadCustomerByFirstName(String firstName);
}
