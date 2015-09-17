package com.finance.service;

import com.finance.core.entity.Customer;
import com.finance.web.domain.CustomerModel;

public interface CustomerService {
	
	void addNewCustomer(Customer customer);
	
	CustomerModel getCustomer(int id);

}
