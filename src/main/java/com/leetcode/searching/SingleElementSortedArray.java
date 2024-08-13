package com.leetcode.searching;

public class SingleElementSortedArray {
    //    https://leetcode.com/problems/single-element-in-a-sorted-array/
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == nums[left + 1])
                left += 2;
            else return nums[left];
            if (nums[right] == nums[right - 1])
                right -= 2;
            else return nums[right];
        }
        return nums[0];
    }

    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int m = left + (right - left) / 2;
            if ((m - 1 < 0 || nums[m - 1] != nums[m]) && (m + 1 == nums.length || nums[m] != nums[m + 1]))
                return nums[m];

            int leftSize = 0;
            leftSize = (nums[m - 1] == nums[m]) ? m - 1 : m;
            if (leftSize % 2 == 1)
                right = m - 1;
            else
                left = m + 1;
        }
        return nums[0];
    }
}
