package com.leetcode.searching;

public class LinearSearch {


//Time complexity O(n)
//	Can be used with not sorted arrays
//	Good for small data
	public int linearSearch(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if(target == nums[i]) return i;
		}
		return -1;
	}
}
