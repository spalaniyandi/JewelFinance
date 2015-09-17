package com.finance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.core.dao.CustomerDAO;
import com.finance.core.dao.ReceiptDAO;
import com.finance.core.entity.Customer;
import com.finance.core.entity.Receipt;
import com.finance.service.ReceiptService;
import com.finance.service.exceptions.ReceiptNotFoundException;
import com.finance.service.mapper.CustomerMapper;
import com.finance.service.mapper.ReceiptMapper;
import com.finance.web.domain.ReceiptModel;
import com.finance.web.domain.ReceiptQueryModel;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private ReceiptDAO receiptDAO;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private ReceiptMapper receiptMapper;

	@Override
	@Transactional
	public long createNewReceipt(ReceiptModel receiptModel) {
		
		Customer customer = customerMapper.mapCustomer(receiptModel);
		
		customerDAO.addCustomer(customer);
		
		//Receipt receipt = receiptMapper.mapReceipt(receiptModel, customer);
		
		//receiptDAO.addReceipt(receipt);
		
		//return receipt.getId();
		return customer.getId();
	}

	@Override
	@Transactional
	public ReceiptModel getReceipt(long receiptId) {
		
		Receipt receipt = receiptDAO.getReceipt(receiptId);
		
		if (receipt == null) {
			throw new ReceiptNotFoundException("Unable to find Receipt ID");
		}
		
		return receiptMapper.mapReceiptModel(receipt);
	}

	@Override
	@Transactional
	public List<ReceiptModel> searchReceipts(ReceiptQueryModel receiptQuery) {
		
		List<ReceiptModel> receiptModels = null;
		List<Receipt> receipts = receiptDAO.searchReceipts(receiptQuery);
		
		for (Receipt receipt : receipts) {
			if (receiptModels == null) {
				receiptModels = new ArrayList<ReceiptModel>();
			}
			receiptModels.add(receiptMapper.mapReceiptModel(receipt));
		}
		return receiptModels;
	}

}
