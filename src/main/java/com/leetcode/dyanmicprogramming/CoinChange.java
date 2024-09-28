package com.leetcode.dyanmicprogramming;

public class CoinChange {
//    https://leetcode.com/problems/coin-change/

    /**
     * Time Complexity: O(amount * n)
     * - We loop over each amount (from 1 to amount), and for each amount, we loop over the coins (n coins).
     * <p>
     * Space Complexity: O(amount)
     * - We use an array `dp` of size (amount + 1) to store intermediate results.
     */

    public int coinChange(int[] coins, int amount) {
        // Edge case: if the amount is 0 or no coins are provided, return 0
        if (amount == 0 || coins.length == 0) return 0;

        // dp[i] will store the minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Initialize dp array: set all values to an amount larger than any valid solution (amount + 1)
        // This is effectively setting them to infinity, since the minimum number of coins to form the amount hasn't been found yet.
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }

        // Iterate through each possible amount from 1 to `amount`
        for (int i = 1; i <= amount; i++) {
            // For each coin in the list of coins
            for (int coin : coins) {
                // Check if it's possible to use this coin (i.e., if subtracting the coin doesn't result in a negative amount)
                if (i - coin >= 0) {
                    // Update dp[i] with the minimum of its current value or the value at dp[i - coin] + 1 (which represents using one more coin)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If dp[amount] still holds the initial value (amount + 1), return -1 as it's impossible to form the amount with the given coins.
        // Otherwise, return dp[amount], which contains the minimum number of coins needed to make the amount.
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

}
