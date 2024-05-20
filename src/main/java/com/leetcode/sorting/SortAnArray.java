package com.leetcode.sorting;

public class SortAnArray {
	//	https://leetcode.com/problems/sort-an-array/description/
	//First solution
//	public int[] sortArray(int[] nums) {
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = 0; j < nums.length - 1; j++) {
//				if(nums[j] > nums[j + 1]){
//					int temp = nums[j];
//					nums[j] = nums [j + 1];
//					nums[j + 1] = temp;
//				}
//			}
//		}
//		return nums;
//	}

//	Second Solution
// Insertion Sort Algorithm
//	https://www.youtube.com/watch?v=nKzEJWbkPbQ
		public int[] sortArray(int[] nums) {

			for (int i = 1; i < nums.length; i++) { // Loop starting from 2 position, considering first position sorted
				var current = nums[i]; // Saves current value to a variable
				var j  = i - 1; // Add to a variable the value of the current position minus one

				while(j >= 0 && nums[j] > current){ // Shift the values to the right until find the position for the current value
					nums[j + 1] = nums[j];
					j--;
				}
				nums[j+1] = current;

			}
			return nums;
		}


}
