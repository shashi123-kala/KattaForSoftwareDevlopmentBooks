package com.sdb.entity;

import java.util.HashSet;

public class SoftwareDevelopmentBookSet {
	private HashSet<SoftwareDevelopmentBook> books;
	private int discount;

	public SoftwareDevelopmentBookSet(HashSet<SoftwareDevelopmentBook> books, int discount) {
		this.books = books;
		this.discount = discount;
	}

	public HashSet<SoftwareDevelopmentBook> getBooks() {
		return books;
	}

	public int getDiscount() {
		return discount;
	}

}
