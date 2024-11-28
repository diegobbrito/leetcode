package com.leetcode.dyanmicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

//    https://leetcode.com/problems/decode-ways/

    //    Dynamic Programming (Top-Down)
//    Time complexity: O(n)
//    Space complexity: O(n)
// This method checks how many ways you can decode the string `s`.
// If the string starts with '0', it's invalid, so return 0.
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0; // Strings starting with '0' can't be decoded.

        // Create a map to memoize results for each index.
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1); // Base case: one way to decode an empty string.

        // Start the recursive depth-first search from index 0.
        return dfs(s, 0, dp);
    }

    // Recursive helper function.
    private static int dfs(String s, int i, Map<Integer, Integer> dp) {
        // If we've already computed the result for this index, return it.
        if (dp.containsKey(i))
            return dp.get(i);
        // If the current character is '0', this path is invalid.
        if (s.charAt(i) == '0')
            return 0;
        // Compute the number of ways to decode starting from index `i`.
        int res = dfs(s, i + 1, dp); // Decode one character.
        // Decode two characters if valid (e.g., '10' to '26').
        if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(s, i + 2, dp);
        }
        // Store the result for this index in the memoization map.
        dp.put(i, res);
        return res;
    }

    //    Dynamic Programming (Bottom-Up)
//    Time complexity: O(n)
//    Space complexity: O(n)
//    Iteratively computes the number of ways to decode the string `s`.
    public int numDecodingsBU(String s) {
        // Create a DP array where dp[i] represents the number of ways to decode `s.substring(i)`.
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1; // Base case: there's one way to decode an empty string.
        // Iterate backwards through the string.
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') // If the current character is '0', no decoding is possible.
                dp[i] = 0;
            else {
                // Decode one character.
                dp[i] = dp[i + 1];
                // Decode two characters if valid (e.g., '10' to '26').
                if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];   // The result for the entire string is stored in dp[0].
    }


    //    Dynamic Programming (Space Optimized)
    //    Time complexity: O(n)
    //    Space complexity: O(1)
    //    Optimized version using constant space.
    public int numDecodingsDP(String s) {
        // Variables to keep track of the last two states.
        int dp = 0, dp1 = 1, dp2 = 0;
        // dp1 represents dp[i+1] (one step ahead),
        // dp2 represents dp[i+2] (two steps ahead).
        for (int i = s.length() - 1; i >= 0; i--) {        // Iterate backwards through the string.
            if (s.charAt(i) == '0')  // If the current character is '0', no decoding is possible.
                dp = 0;
            else {
                // Decode one character.
                dp = dp1;
                // Decode two characters if valid (e.g., '10' to '26').
                if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                    dp += dp2;
            }
            // Update dp2 and dp1 for the next iteration.
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;     // The final result is stored in dp1.
    }

}
