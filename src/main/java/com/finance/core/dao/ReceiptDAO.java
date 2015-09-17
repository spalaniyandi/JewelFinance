package com.finance.core.dao;

import java.util.List;

import com.finance.core.entity.Receipt;
import com.finance.web.domain.ReceiptQueryModel;

public interface ReceiptDAO {
	
	/**
	 * save a new receipt
	 * @param receipt
	 */
	void addReceipt(Receipt receipt);
	
	/**
	 * get receipt from db
	 * @param receiptId
	 */
	Receipt getReceipt(long receiptId);
	
	/**
	 * search receipts and bring it
	 * @param receiptQuery
	 * @return
	 */
	List<Receipt> searchReceipts(ReceiptQueryModel receiptQuery);

}
