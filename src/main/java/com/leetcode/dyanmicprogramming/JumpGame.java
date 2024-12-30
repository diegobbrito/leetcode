package com.leetcode.dyanmicprogramming;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {
//    https://leetcode.com/problems/jump-game/

    //    Dynamic Programming (Top-Down) with Memoization
//    Time complexity: O(n^2)
//    Space complexity: O(n)
//    dfs(i) returns true if we can reach the last index starting from index i
    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(nums, 0, memo);
    }

    private boolean dfs(int[] nums, int index, Map<Integer, Boolean> memo) {
        if (memo.containsKey(index)) return memo.get(index);
        if (index == nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        int end = Math.min(nums.length - 1, index + nums[index]);
        for (int i = index + 1; i <= end; i++) {
            if (dfs(nums, i, memo)) {
                memo.put(index, true);
                return true;
            }
        }
        memo.put(index, false);
        return false;
    }

    //    Dynamic Programming (Bottom-Up) with Tabulation
//    Time complexity: O(n^2)
//    Space complexity: O(n)
//    dp[i] = true if we can reach the last index starting from index i
    public boolean canJumpTabulation(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true; // last index is always reachable
        for (int i = n - 2; i >= 0; i--) {
            int end = Math.min(n - 1, i + nums[i]); // farthest index we can reach from index i
            for (int j = i + 1; j <= end; j++) { // check if we can reach the last index from index j
                if (dp[j]) { // if we can reach the last index from index j, we can reach the last index from index i
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0]; // can we reach the last index starting from index 0
    }
}
