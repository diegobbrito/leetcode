package com.leetcode.sorting;

public class KthLargestElementArray {

	public static void main(String[] args) {
		findKthLargest(new int[] {3,2,1,5,6,4}, 2);
	}
	public static int findKthLargest(int[] nums, int k) {
		//Change the target to the position of the element searched in a sorted array
		return quickSelect(nums, 0, nums.length - 1, nums.length - k);
	}

	private static int quickSelect(int[] nums, int start, int end, int target) {
		int p = start;
		int pivot = nums[end]; // Use to avoid accessing the array in all iterations
		for (int j = start; j < end; j++) {
			if(nums[j] < pivot){
				swap(nums, p++, j);
			}
		}
		swap(nums, p, end);
	//Use the same logic of quickSort, but only use recursive calls on the part of the array where the target index is.
		// The variable p, is the index where the elements before as less than and the elements after are more than.
		//If the p index is greater than the target index, its call the method on the left side
		// start target p end
		//If the p index is less than the target index, its call the method on the right side
		// start p target end
		if (p > target)
			return quickSelect(nums, start, p - 1, target);
		if (p < target)
			return quickSelect(nums, p + 1, end, target);

		return nums[p];
	}

//Swap function to make the code more readable
	private static void swap(int[] nums, int a, int b) {
		var temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
