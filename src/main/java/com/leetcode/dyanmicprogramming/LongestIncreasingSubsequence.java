package com.leetcode.dyanmicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

//    https://leetcode.com/problems/longest-increasing-subsequence/

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int current = nums[i];
                int previous = nums[j];
                if (current > previous) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
