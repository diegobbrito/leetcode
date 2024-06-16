package com.leetcode.searching;

public class KokoEatingBananas {
//	https://leetcode.com/problems/koko-eating-bananas/
	public int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int right = getMaxValue(piles); //Get the Max value the monkey can eat in an hour
		while (left <= right){
			int middle = left + (right - left) / 2;
			int hoursSpent = 0;
			for (int pile : piles) {
				hoursSpent += pile / middle;
				if(pile % middle != 0) hoursSpent++;
			}
			if (hoursSpent <= h  && hoursSpent > 0){
				right = middle -1;
			} else if (hoursSpent > h || hoursSpent < 0) {
				left = middle + 1;
			}
		}
		return left;
	}

	private int getMaxValue(int[] piles) {
		int max = 0;
		for (int pile : piles)
			if(pile > max)
				max = pile;
		return max;
	}
}
