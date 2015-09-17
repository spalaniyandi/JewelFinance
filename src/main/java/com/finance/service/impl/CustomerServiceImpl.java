package com.finance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.core.dao.CustomerDAO;
import com.finance.core.entity.Customer;
import com.finance.core.entity.IDCard;
import com.finance.core.entity.SureshTab;
import com.finance.service.CustomerService;
import com.finance.web.domain.CustomerModel;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public void addNewCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public CustomerModel getCustomer(int id) {
		Customer customer = customerDAO.loadCustomer(id);
		return null;
	}

}
