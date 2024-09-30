package com.leetcode.arrays;

public class PreFixSum {
    int[] prefix;

    public PreFixSum(int[] nums) {
        prefix = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            prefix[i] = total;
        }
    }

    public int rangeSum(int left, int right) {
        int leftSum = left > 0 ? prefix[left - 1] : 0;
        int rightSum = prefix[right];
        return rightSum - leftSum;
    }
}
