package com.leetcode.arrays;

public class FindPivotIndex {
    //    https://leetcode.com/problems/find-pivot-index/
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            var rightSum = total - nums[i] - leftSum;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
