package com.sdb.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sdb.entity.SoftwareDevelopmentBook;
import com.sdb.entity.SoftwareDevelopmentBookSetDiscount;

public class CalculateDiscountTest {

	CalculateDiscount calculateDiscount;

	public static final int FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS = 5;
	public static final int TEN_PERCENT_DISCOUNT_OF_TWO_BOOKS = 10;
	public static final int TWENTY_PERCENT_DISCOUNT_OF_TWO_BOOKS = 20;
	public static final int TWENTY_FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS = 25;

	public static final int TWO_BOOKS = 2;
	public static final int THREE_BOOKS = 3;
	public static final int FOUR_BOOKS = 4;
	public static final int FIVE_BOOKS = 5;

	@BeforeEach
	public void setup() {
		List<SoftwareDevelopmentBookSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();
		byDifferentCopiesDiscountList
				.add(new SoftwareDevelopmentBookSetDiscount(TWO_BOOKS, FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList
				.add(new SoftwareDevelopmentBookSetDiscount(THREE_BOOKS, TEN_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList
				.add(new SoftwareDevelopmentBookSetDiscount(FOUR_BOOKS, TWENTY_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList
				.add(new SoftwareDevelopmentBookSetDiscount(FIVE_BOOKS, TWENTY_FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		calculateDiscount = new CalculateDiscount(byDifferentCopiesDiscountList);
	}

	@Test
	public void initializeToBuyBook() {
		assertNotNull(calculateDiscount);
	}

	@Test
	public void buyingOneBook() {
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		calculateDiscount.Add(sdbFirstI);
		assertEquals(50.0, calculateDiscount.getTotalPrice());
	}

	@Test
	public void buyingTwoCopiesOfDifferentBook() {
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		SoftwareDevelopmentBook sdbSecondI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIBook();
		calculateDiscount.Add(sdbFirstI);
		calculateDiscount.Add(sdbSecondI);
		assertEquals(95.0, calculateDiscount.getTotalPrice());
	}

	@Test
	public void buyingThreeCopiesOfDifferentBook() {
		SoftwareDevelopmentBook sdbFirstI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIBook();
		SoftwareDevelopmentBook sdbSecondI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIBook();
		SoftwareDevelopmentBook sdbThirdI = SoftwareDevlopmentBookList.GivenASoftwareDevelopmentIIIBook();
		calculateDiscount.Add(sdbFirstI);
		calculateDiscount.Add(sdbSecondI);
		calculateDiscount.Add(sdbThirdI);
		assertEquals(135, calculateDiscount.getTotalPrice());

	}

}
