package com.leetcode.searching;

public class GuessNumberHigherLower {
//	https://leetcode.com/problems/guess-number-higher-or-lower/
	public int guessNumber(int n) {
		int low = 0;
		int high = n;
		int middle = low + (high - low) / 2;
		var result = guess(middle);
		while(result != 0){
			if(result < 0){
				high = middle - 1;
				middle = low + (high - low) / 2;
			}else{
				low = middle + 1;
				middle = low + (high - low) / 2;
			}
			result = guess(middle);
		}
		return middle;
	}

	private int guess(int middle) {
		return 0;
	}
}
