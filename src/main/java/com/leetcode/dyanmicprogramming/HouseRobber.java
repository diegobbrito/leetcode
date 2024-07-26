package com.leetcode.dyanmicprogramming;

public class HouseRobber {
    //    https://leetcode.com/problems/house-robber/
    public int rob(int[] nums) {
        // If the input array is null or empty, return 0 (nothing to rob)
        if (nums == null || nums.length == 0) return 0;

        // If there is only one house, return the value of that house
        if (nums.length == 1) return nums[0];

        // Initialize two variables to keep track of the maximum amount that can be robbed
        // dp1 represents the maximum amount robbed up to the previous house
        // dp2 represents the maximum amount robbed up to the current house
        int dp1 = 0;
        int dp2 = 0;

        // Temporary variable to store the maximum amount robbed for the current iteration
        int temp;
        // Iterate through each house
        for (int num : nums) {
            // Calculate the maximum amount that can be robbed by either robbing the current house
            // and adding its value to dp1 (skipping the previous house) or not robbing the current house
            temp = Math.max(dp1 + num, dp2);
            // Update dp1 to the value of dp2 for the next iteration
            dp1 = dp2;
            // Update dp2 to the newly calculated maximum amount (temp)
            dp2 = temp;
        }
        // Return the maximum amount that can be robbed, which is stored in dp2
        return dp2;
    }

}
