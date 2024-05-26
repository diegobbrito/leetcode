package com.leetcode.sorting;

public class SortColors {
//	https://leetcode.com/problems/sort-colors/
//	Used bucket sort, complexity O(n)
	public void sortColors(int[] nums) {
		int[] bucket = new int[3];
		for (int i = 0; i < nums.length; i++) {
			bucket[nums[i]] += 1;
		}

		int index = 0;
		for (int i = 0; i < bucket.length; i++) {
			var temp = bucket[i];
			for (int j = 0; j < temp; j++) {
				nums[index++] = i;
			}
		}
	}
}
