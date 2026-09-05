package com.leetcode.arrays;

public class MaximumAscendingSubarraySum {
//    https://leetcode.com/problems/maximum-ascending-subarray-sum/
//    Time complexity: O(n)
//    Space complexity: O(1)

    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                curr = nums[i];
            } else {
                curr += nums[i];
                max = Math.max(max, curr);
            }
        }

        return max;
    }
}
