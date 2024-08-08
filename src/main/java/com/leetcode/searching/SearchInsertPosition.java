package com.leetcode.searching;

public class SearchInsertPosition {
    //    Time Complexity O(n)
//    Memory Complexity O(1)
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= target) return i;
        return nums.length;
    }

    //    Time Complexity O(logn)
    //    Memory Complexity O(1)
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return mid;
    }
}
