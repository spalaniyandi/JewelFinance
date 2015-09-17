package com.finance.service;

import java.util.List;

import com.finance.web.domain.ReceiptModel;
import com.finance.web.domain.ReceiptQueryModel;

public interface ReceiptService {
	
	/**
	 * Creates new receipt and returns the id
	 * @param receipt
	 * @return
	 */
	public long createNewReceipt(ReceiptModel receipt);

	/**
	 * Get receipt from DB
	 * @param receiptId
	 */
	public ReceiptModel getReceipt(long receiptId);
	
	/**
	 * Get list of receipts with some criteria
	 * @param receiptQuery
	 * @return
	 */
	public List<ReceiptModel> searchReceipts(ReceiptQueryModel receiptQuery);

}
