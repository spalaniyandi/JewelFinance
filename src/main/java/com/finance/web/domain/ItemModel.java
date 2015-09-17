package com.finance.web.domain;

import java.io.Serializable;

public class ItemModel implements Serializable {
	
	private static final long serialVersionUID = 5732330225807914900L;

	private String itemName;
	
	private int itemQty;
	
	public ItemModel() {
		this.itemQty = 1;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

}
