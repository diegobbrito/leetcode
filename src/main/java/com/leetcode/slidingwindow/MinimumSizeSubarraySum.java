package com.leetcode.slidingwindow;

public class MinimumSizeSubarraySum {

    //https://leetcode.com/problems/minimum-size-subarray-sum/
    // Sliding window solution
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, 1 + right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
