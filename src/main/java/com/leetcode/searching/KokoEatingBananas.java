package com.leetcode.searching;

public class KokoEatingBananas {
//	https://leetcode.com/problems/koko-eating-bananas/description/
	public int minEatingSpeed(int[] piles, int h) {
		if(piles.length == 1) return piles[0] / h;
		int k = 0;
		if(h == piles.length){
			int max = 0;
			for (int i = 1; i < piles.length; i++) {
				if(piles[i] > piles[max])
					max = i;
			}
			return piles[max];
		}
		return k;
	}
}
