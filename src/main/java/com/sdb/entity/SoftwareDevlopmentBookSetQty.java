package com.sdb.entity;

public class SoftwareDevlopmentBookSetQty {

	private SoftwareDevelopmentBook book;
	private int quantity;

	public SoftwareDevlopmentBookSetQty(SoftwareDevelopmentBook book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}

	public SoftwareDevelopmentBook getBook() {
		return book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void changeQuantity(int quantity) {
		this.quantity = quantity;
	}

}
