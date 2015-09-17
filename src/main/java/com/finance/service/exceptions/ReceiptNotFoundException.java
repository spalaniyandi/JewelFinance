package com.finance.service.exceptions;

public class ReceiptNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 3125668249075787539L;

	public ReceiptNotFoundException(String message) {
		super(message);
	}

}
