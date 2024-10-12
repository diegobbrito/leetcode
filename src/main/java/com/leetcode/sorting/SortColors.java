package com.leetcode.sorting;

public class SortColors {
//	https://leetcode.com/problems/sort-colors/
//	Used bucket sort, complexity O(n)
//	Space Complexity: O(1)
public void sortColors(int[] nums) {
	// Step 1: Initialize a bucket array of size 3 to count occurrences of 0, 1, and 2.
	int[] bucket = new int[3];

	// Step 2: Iterate through the input array and increment the corresponding bucket index.
	for (int n : nums)
		bucket[n] = bucket[n] + 1;

	// Step 3: Reconstruct the sorted array based on the bucket counts.
	int j = 0;
	for (int i = 0; i < 3; i++) // Loop through the bucket (0, 1, 2).
		for (int k = 0; k < bucket[i]; k++) // Add 'i' to nums for the number of times it appears.
			nums[j++] = i;
}

	//Three pointers:
	//left: Tracks the boundary where 0s should be placed.
	//right: Tracks the boundary where 2s should be placed.
	//i: Current index that iterates through the array.
	//	Logic:
	//If the current element (nums[i]) is 0, we swap it with the left pointer and move both left and i forward.
	//If the current element is 2, we swap it with the right pointer and move right backward but leave i the same to recheck the swapped value.
	//If the current element is 1, we just move i forward, as 1 is already in its correct place.
	//Time Complexity: O(n): Each element is processed at most once.
	// In the worst case, i only moves right when it encounters 1s, and it is only swapped when encountering 0s or 2s.
	//Space Complexity:
	//O(1): Only a few integer variables (left, right, i) and a temporary variable for swapping are used,
	// which means constant space is required.
	public void sortColors2(int[] nums) {
		int left = 0, right = nums.length - 1;
		int i = 0;

		// Step 1: Iterate through the array using 'i' while keeping track of 'left' and 'right'.
		while (i <= right) {
			if (nums[i] == 0) {
				// If the current number is 0, swap it with the 'left' boundary and move 'left' forward.
				swap(nums, left++, i);
			} else if (nums[i] == 2) {
				// If the current number is 2, swap it with the 'right' boundary and move 'right' backward.
				swap(nums, right--, i--);
			}
			i++;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
