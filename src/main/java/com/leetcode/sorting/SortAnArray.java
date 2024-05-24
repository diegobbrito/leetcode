package com.leetcode.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortAnArray {
	//	https://leetcode.com/problems/sort-an-array/description/
	//First solution
	public int[] sortArray(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if(nums[j] > nums[j + 1]){
					int temp = nums[j];
					nums[j] = nums [j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		return nums;
	}

}
