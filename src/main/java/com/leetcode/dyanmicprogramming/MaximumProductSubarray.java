package com.leetcode.dyanmicprogramming;

public class MaximumProductSubarray {

    //    https://leetcode.com/problems/maximum-product-subarray/
    //    Time complexity: O(n)
    //    Space complexity: O(1)
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;//store the max value
            int currentMax = Math.max(max * nums[i], min * nums[i]);
            max = Math.max(currentMax, nums[i]);//max is the max of max*nums[i], min*nums[i] and nums[i]
            int currentMin = Math.min(temp * nums[i], min * nums[i]);
            min = Math.min(currentMin, nums[i]); //min is the min of max*nums[i], min*nums[i] and nums[i]
            result = Math.max(result, max); //result is the max of result and max
        }
        return result;
    }
}
