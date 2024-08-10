package com.leetcode.searching;

public class ValidPerfectSquare {
//	https://leetcode.com/problems/valid-perfect-square/

	public static boolean isPerfectSquare(int num) {
		if(num == 1) return true;

		int left = 2, right = num / 2;

		while (left <= right){
			int mid = left + (right - left) / 2;
			long result = (long) mid * mid;
			if(result == num) return true;
			else if (result > num || result < 0 ) {
				right = mid - 1;
			}else
				left = mid + 1;
		}

		return false;
	}
}
