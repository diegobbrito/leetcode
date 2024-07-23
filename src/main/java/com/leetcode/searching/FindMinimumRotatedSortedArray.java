package com.leetcode.searching;

public class FindMinimumRotatedSortedArray {
    //    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    public int findMin2(int[] nums) {
        // Initialize the result with the first element of the array
        int result = nums[0];
        // Initialize the left and right pointers
        var left = 0;
        var right = nums.length - 1;

        // Loop until the left pointer exceeds the right pointer
        while (left <= right) {
            // If the subarray from left to right is sorted, the minimum element is nums[left]
            if (nums[left] < nums[right]) {
                // Update result with the minimum value between result and nums[left]
                result = Math.min(result, nums[left]);
                // Exit the loop as we have found the minimum element in the sorted subarray
                break;
            }
            // Calculate the middle index to divide the array
            int middle = left + (right - left) / 2;
            // Update result with the minimum value between result and nums[middle]
            result = Math.min(result, nums[middle]);
            // If the left half is sorted (nums[middle] >= nums[left])
            if (nums[middle] >= nums[left]) {
                // Move the left pointer to the right of middle, excluding the middle element
                left = middle + 1;
            } else {
                // Otherwise, the right half is sorted, move the right pointer to the left of middle
                right = middle - 1;
            }
        }
        // Return the minimum element found
        return result;
    }

}
