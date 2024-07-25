package com.leetcode.searching;

public class SearchRotatedSortedArray {
//    https://leetcode.com/problems/search-in-rotated-sorted-array/

    public static void main(String[] args) {
        search(new int[]{5, 1, 3}, 3);
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // Initialize the left and right pointers

        // Loop while the search space is valid
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index to avoid overflow

            // Check if the target is at the middle position
            if (nums[mid] == target)
                return mid; // Target found, return its index

            // Determine if is in the left half
            if (nums[left] <= nums[mid]) {
                // Check if the target is in the left half
                if (target > nums[mid] || target < nums[left])
                    left = mid + 1; // Target is not in the left half, move the left pointer to mid + 1
                else
                    right = mid - 1; // Target is in the left half, move the right pointer to mid - 1
            } else {
                // Check if the target is in the right half
                if (target < nums[mid] || target > nums[right])
                    right = mid - 1; // Target is not in the right half, move the right pointer to mid - 1
                else
                    left = mid + 1; // Target is in the right half, move the left pointer to mid + 1
            }
        }

        return -1; // Target not found, return -1
    }

}
