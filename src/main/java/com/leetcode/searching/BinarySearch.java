package com.leetcode.searching;

public class BinarySearch {
//	https://leetcode.com/problems/binary-search/description/

// Time complexity O(log(n))
//	Memory complecity O(1)
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right){
			//Here its calculated the distance between left and right, then adding left to get the middle
			// This avoid overflow if the numbers are close to the maximum integer in the (left + right) /2
			int middle = left + (right - left) / 2;
			if (target > nums[middle])
				left = middle + 1;
			else if(target < nums[middle])
				right = middle - 1;
			else return middle;
		}
		return -1;
	}
}
