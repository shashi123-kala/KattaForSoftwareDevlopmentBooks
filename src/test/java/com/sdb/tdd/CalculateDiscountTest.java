package com.sdb.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sdb.entity.SoftwareDevelopmentBook;
import com.sdb.entity.SoftwareDevelopmentBookSetDiscount;

import comsbd.Constants.SoftwareDevBooksConstant;

public class CalculateDiscountTest {

	CalculateDiscount calculateDiscount;

	

	@BeforeEach
	public void setup() {
		List<SoftwareDevelopmentBookSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();
		byDifferentCopiesDiscountList
				.add(new SoftwareDevelopmentBookSetDiscount(SoftwareDevBooksConstant.TWO_BOOKS,SoftwareDevBooksConstant.FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList
				.add(new SoftwareDevelopmentBookSetDiscount(SoftwareDevBooksConstant.THREE_BOOKS, SoftwareDevBooksConstant.TEN_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList
				.add(new SoftwareDevelopmentBookSetDiscount(SoftwareDevBooksConstant.FOUR_BOOKS, SoftwareDevBooksConstant.TWENTY_PERCENT_DISCOUNT_OF_TWO_BOOKS));
		byDifferentCopiesDiscountList
				.add(new SoftwareDevelopmentBookSetDiscount(SoftwareDevBooksConstant.FIVE_BOOKS, SoftwareDevBooksConstant.TWENTY_FIVE_PERCENT_DISCOUNT_OF_TWO_BOOKS));
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
