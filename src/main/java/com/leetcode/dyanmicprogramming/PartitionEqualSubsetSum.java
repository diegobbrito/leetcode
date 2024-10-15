package com.leetcode.dyanmicprogramming;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int num : nums) {
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                if (t + num == target) return true;
                nextDp.add(t + num);
                nextDp.add(t);
            }
            dp = nextDp;
        }
        return dp.contains(target);
    }

    //    https://leetcode.com/problems/partition-equal-subset-sum/
//    Time Complexity: O(n * target)
//    Space Complexity: O(target)
    public boolean canPartition(int[] nums) {
        // Initialize the total sum of the elements in the array
        int sum = 0;
        for (int num : nums)
            sum += num; // Sum up all the elements
        // If the total sum is odd, we can't partition the array into two equal subsets
        if (sum % 2 != 0) return false;
        // We are aiming to find a subset with sum equal to sum / 2
        int target = sum / 2;
        // Create a dynamic programming array where dp[i] is true if we can form sum 'i'
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // We can always form the sum 0 (by taking no elements)
        // Iterate over all numbers in the array
        for (int num : nums)
            // Traverse the dp array backwards to avoid overwriting results of the current iteration
            for (int i = target; i >= num; i--)
                if (dp[i - num]) {
                    if (i == target) return true;
                    dp[i] = true;
                }

        // Return true if we can form the target sum
        return dp[target];
    }

}
