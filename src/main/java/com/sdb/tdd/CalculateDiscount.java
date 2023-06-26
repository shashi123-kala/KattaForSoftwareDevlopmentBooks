package com.sdb.tdd;

public class CalculateDiscount {
	public double getTotalPrice(double dis, int noOfBooks) {
		double amtAfterDis = 0.00;
		if (noOfBooks == 1) {
			amtAfterDis = 50 - (50 * (dis / 100));
		} else if (noOfBooks == 2) {
			double count = noOfBooks * 50.00;
			amtAfterDis = count - (count * (dis / 100));
		}
		return amtAfterDis;
	}

}
