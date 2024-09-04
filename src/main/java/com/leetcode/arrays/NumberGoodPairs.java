package com.leetcode.arrays;

public class NumberGoodPairs {
//	https://leetcode.com/problems/number-of-good-pairs/
	public int numIdenticalPairs(int[] nums) {
		int result = 0;
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			int curr = nums[i];
			for (int j = i + 1; j < n; j++) {
				if(curr == nums[j])
					result++;
			}
		}
		return result;
	}
}
