package com.sdb.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CalculateDiscountTest {

	public static final String SOFTWARE_DEVELOPMENT_BOOK_I = "Clean Code (Robert Martin, 2008)";
	public static final String SOFTWARE_DEVELOPMENT_BOOK_II = "The Clean Coder (Robert Martin, 2011)";
	public static final String SOFTWARE_DEVELOPMENT_BOOK_III = "Clean Architecture (Robert Martin, 2017)";
	public static final String SOFTWARE_DEVELOPMENT_BOOK_IV = "Test Driven Development by Example (Kent Beck, 2003)";
	public static final String SOFTWARE_DEVELOPMENT_BOOK_V = "Working Effectively With Legacy Code (Michael C. Feathers, 2004)";
	CalculateDiscount calculateDiscount = new CalculateDiscount();

	@Test
	public void initializeToBuyBook() {
		assertNotNull(calculateDiscount);
	}

	@Test
	public void buyingOneBook() {
		String book = SOFTWARE_DEVELOPMENT_BOOK_I;
		double discount = 0.00;
		int noOfBooks = 1;
		assertEquals(50.0, calculateDiscount.getTotalPrice(discount, noOfBooks));
	}

	@Test
	public void buyingTwoCopiesOfDifferentBook() {
		List<String> sdbList = new ArrayList<>();
		String book = SOFTWARE_DEVELOPMENT_BOOK_I;
		String book2 = SOFTWARE_DEVELOPMENT_BOOK_II;
		double discount = 5;
		sdbList.add(book);
		sdbList.add(book2);
		int noOfBooks = sdbList.size();
		assertEquals(95.0, calculateDiscount.getTotalPrice(discount, noOfBooks));
	}

	@Test
	public void buyingThreeCopiesOfDifferentBook() {
		List<String> sdbList = new ArrayList<>();
		String book = SOFTWARE_DEVELOPMENT_BOOK_I;
		String book2 = SOFTWARE_DEVELOPMENT_BOOK_II;
		String book3 = SOFTWARE_DEVELOPMENT_BOOK_III;
		double discount = 10;
		sdbList.add(book);
		sdbList.add(book2);
		sdbList.add(book3);
		int noOfBooks = sdbList.size();
		assertEquals(135, calculateDiscount.getTotalPrice(discount, noOfBooks));

	}

}
