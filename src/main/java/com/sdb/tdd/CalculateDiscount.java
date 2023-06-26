package com.sdb.tdd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.sdb.entity.SoftwareDevelopmentBook;
import com.sdb.entity.SoftwareDevelopmentBookSet;
import com.sdb.entity.SoftwareDevelopmentBookSetDiscount;
import com.sdb.entity.SoftwareDevlopmentBookSetQty;

public class CalculateDiscount {

	List<SoftwareDevelopmentBookSetDiscount> discounts;

	public CalculateDiscount(List<SoftwareDevelopmentBookSetDiscount> discounts) {
		this.discounts = discounts;
	}

	private List<SoftwareDevlopmentBookSetQty> sdbQtySet = new ArrayList<>();

	public double getTotalPrice() {
		double amtAfterDis = 0.00;
		if (sdbQtySet.size() == 1) {
			double dis = 0.0;
			amtAfterDis = 50 - (50 * (dis / 100));
		} else {
			List<SoftwareDevelopmentBookSet> setsOfDifferentBooks = getBestCombinationBooksSets(sdbQtySet);
			double setPrice = 0.0;
			for (SoftwareDevelopmentBookSet booksSet : setsOfDifferentBooks) {
				for (SoftwareDevelopmentBook book : booksSet.getBooks()) {
					setPrice += book.getPrice();
				}
				setPrice = setPrice * (1.0 - (booksSet.getDiscount() / 100.0));
				amtAfterDis += setPrice;
				setPrice = 0;
			}
		}
		return amtAfterDis;
	}

	public void Add(SoftwareDevelopmentBook book) {
		SoftwareDevlopmentBookSetQty existedItem = null;
		for (SoftwareDevlopmentBookSetQty item : sdbQtySet) {
			if (item.getBook().equals(book))
				existedItem = item;
		}
		if (existedItem != null)
			existedItem.changeQuantity(existedItem.getQuantity() + 1);
		else
			sdbQtySet.add(new SoftwareDevlopmentBookSetQty(book, 1));
	}

	private List<SoftwareDevelopmentBookSet> getBestCombinationBooksSets(
			List<SoftwareDevlopmentBookSetQty> bookSetQty) {
		List<List<SoftwareDevelopmentBookSet>> differentBooksSetsCombinations = new ArrayList<>();
		for (int i = bookSetQty.size(); i >= 1; i--) {
			differentBooksSetsCombinations.add(calculateDifferentBooksSetsByMaxSize(bookSetQty, i));
		}
		List<SoftwareDevelopmentBookSet> optimizeSetList;
		if (differentBooksSetsCombinations.size() > 1)
			optimizeSetList = selectBooksSetsWithMaxDiscount(differentBooksSetsCombinations);
		else
			optimizeSetList = differentBooksSetsCombinations.get(0);

		return optimizeSetList;

	}

	private List<SoftwareDevelopmentBookSet> calculateDifferentBooksSetsByMaxSize(
			List<SoftwareDevlopmentBookSetQty> shoppingCartItems, int maxSizeSet) {
		List<SoftwareDevlopmentBookSetQty> remainingShoppingCartItems = cloneShoppingCartItems(shoppingCartItems);
		List<SoftwareDevelopmentBookSet> setsOfDifferentBooks = new ArrayList<>();
		while (remainingShoppingCartItems.size() > 0) {
			final SoftwareDevelopmentBookSet oneSetOfDifferentBooks = createNextSet(remainingShoppingCartItems,
					maxSizeSet);
			setsOfDifferentBooks.add(oneSetOfDifferentBooks);
		}
		return setsOfDifferentBooks;
	}

	private SoftwareDevelopmentBookSet createNextSet(List<SoftwareDevlopmentBookSetQty> remainingShoppingCartItems,
			int maxSizeSet) {
		HashSet<SoftwareDevelopmentBook> books = new HashSet<>();
		for (SoftwareDevlopmentBookSetQty item : new ArrayList<>(remainingShoppingCartItems)) {
			books.add(item.getBook());
			if (item.getQuantity() == 1)
				remainingShoppingCartItems.remove(item);
			else
				item.changeQuantity(item.getQuantity() - 1);
			if (books.size() == maxSizeSet)
				break;
		}
		SoftwareDevelopmentBookSet booksSet = new SoftwareDevelopmentBookSet(books, getDiscount(books.size()));
		return booksSet;
	}

	private List<SoftwareDevelopmentBookSet> selectBooksSetsWithMaxDiscount(
			List<List<SoftwareDevelopmentBookSet>> booksSetsCombinations) {
		List<SoftwareDevelopmentBookSet> maxDiscountBooksSets = null;
		int maxBooksSetsDiscount = 0;
		int totalBooksSetsDiscount = 0;
		for (List<SoftwareDevelopmentBookSet> booksSets : booksSetsCombinations) {
			for (SoftwareDevelopmentBookSet booksSet : booksSets) {
				totalBooksSetsDiscount += booksSet.getDiscount();
			}
			if (maxBooksSetsDiscount < totalBooksSetsDiscount) {
				maxDiscountBooksSets = booksSets;
				maxBooksSetsDiscount = totalBooksSetsDiscount;
			}
			totalBooksSetsDiscount = 0;
		}
		return maxDiscountBooksSets;
	}

	private List<SoftwareDevlopmentBookSetQty> cloneShoppingCartItems(
			List<SoftwareDevlopmentBookSetQty> shoppingCartItems) {
		List<SoftwareDevlopmentBookSetQty> shoppingCartItemsCopy = new ArrayList<>();
		for (SoftwareDevlopmentBookSetQty item : shoppingCartItems) {
			shoppingCartItemsCopy.add(new SoftwareDevlopmentBookSetQty(item.getBook(), item.getQuantity()));
		}
		return shoppingCartItemsCopy;
	}

	private int getDiscount(int differentBooksCount) {
		int defaultDiscount = 0;
		for (SoftwareDevelopmentBookSetDiscount discount : discounts) {
			if (differentBooksCount == discount.getDifferentCopies())
				return discount.getDiscount();
		}
		return defaultDiscount;
	}

}
