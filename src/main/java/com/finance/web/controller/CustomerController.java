package com.finance.web.controller;

import java.util.Date;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finance.core.dao.CustomerDAO;
import com.finance.core.entity.Address;
import com.finance.core.entity.Customer;
import com.finance.core.entity.IDCard;
import com.finance.core.entity.Phone;
import com.finance.service.CustomerService;
import com.finance.web.domain.CustomerModel;
import com.finance.web.domain.CustomerQueryModel;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value = "search/customer", method=RequestMethod.GET)
	public String viewCustomer(Model model) {
		CustomerQueryModel customerQuery = new CustomerQueryModel();
		model.addAttribute("customerQuery", customerQuery);
		return "searchCustomer";
	}

	/*@RequestMapping(value = "customer", method=RequestMethod.POST)
	public CustomerModel getCustomer(CustomerQueryModel customerQuery) {
		//customerService.addNewCustomer(new Customer());
		customerService.getCustomer(1);
		return null;
	}*/
	
	@RequestMapping(value="customer", method=RequestMethod.GET)
	public String getCustomer(Model model) {
		model.addAttribute("customer", new CustomerModel());
		return "customer";
	}
	
	@RequestMapping(value="customer", method=RequestMethod.POST)
	public String createCustomer(
			@Valid @ModelAttribute("customerModel") CustomerModel customer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.debug("post customer has errors");
			return "customer";
		}
		return null;
	}

}
