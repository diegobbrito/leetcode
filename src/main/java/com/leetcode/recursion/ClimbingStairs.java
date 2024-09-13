package com.leetcode.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
//	https://leetcode.com/problems/climbing-stairs/

	// Recursive approach: A simple solution using recursion.
	// Time complexity: O(2^n), since it recalculates the same subproblems multiple times.
	public int climbStairs(int n) {
		// Base case: If n is 0 or 1, return n (1 way to climb 1 stair, 0 ways to climb 0 stairs).
		if (n <= 1)
			return n;
		// Recursive call: Climb by taking 1 or 2 steps.
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	// Optimized iterative solution using constant space.
	// Time complexity: O(n), Space complexity: O(1), as it uses only two variables.
	public int climbStairsOptimize(int n) {
		int one = 1; // Represents the number of ways to climb to the current stair.
		int two = 1; // Represents the number of ways to climb to the previous stair.

		// Loop through stairs 2 to n.
		for (int i = 1; i < n; i++) {
			// Calculate the total ways to reach the next stair.
			int temp = one;
			one = one + two; // The current stair is the sum of the two previous stairs.
			two = temp; // Update the previous stair.
		}
		return one; // The variable 'one' contains the number of ways to reach the nth stair.
	}

	// Dynamic programming solution using a bottom-up approach.
	// Time complexity: O(n), Space complexity: O(n).
	public int climbStairsBottomUp(int n) {
		// Initialize an array to store the number of ways to reach each stair.
		int[] dp = new int[n + 1];
		dp[0] = 1; // Base case: 1 way to stay on the ground.
		dp[1] = 1; // Base case: 1 way to climb the first stair.

		// Fill the dp array for stairs 2 to n.
		for (int i = 2; i < n + 1; i++) {
			// Each stair can be reached from the previous stair or two stairs before.
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n]; // Return the number of ways to reach the nth stair.
	}

	// Top-down approach with memoization.
	// Time complexity: O(n), Space complexity: O(n).
	public int climbStairsTopDownWithMemo(int n) {
		// Initialize a memoization array to store the results of subproblems.
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1); // Fill the memo array with -1 to indicate uncalculated values.

		// The final answer is the sum of the ways to reach the last two stairs.
		return climbStairsWithMemo(n - 1, memo) + climbStairsWithMemo(n - 2, memo);
	}

	// Helper function to perform the recursive calculation with memoization.
	private int climbStairsWithMemo(int n, int[] memo) {
		// Base case: If n is less than 0, there are no ways to reach the stair.
		if (n < 0) return 0;
		// Base case: If n is 0 or 1, there is 1 way to reach the stair.
		if (n == 0 || n == 1) {
			memo[n] = 1; // Store the result in the memo array.
			return memo[n];
		}
		// If the result is already calculated, return it from the memo array.
		if (memo[n] != -1) return memo[n];

		// Recursive call: Calculate the result and store it in the memo array.
		memo[n] = climbStairsWithMemo(n - 1, memo) + climbStairsWithMemo(n - 2, memo);
		return memo[n];
	}

	// Another top-down approach with memoization using a HashMap.
	// Time complexity: O(n), Space complexity: O(n).
	public int climbStairs2(int n) {
		// Initialize a HashMap to store the results of subproblems.
		Map<Integer, Integer> memo = new HashMap<>();
		return climbStairs(n, memo); // Start the recursion.
	}

	// Helper function to perform the recursive calculation with memoization using HashMap.
	private int climbStairs(int n, Map<Integer, Integer> memo) {
		// Base case: If n is 0 or 1, there is 1 way to reach the stair.
		if (n == 0 || n == 1) {
			return 1;
		}
		// If the result is not in the HashMap, calculate it recursively.
		if (!memo.containsKey(n)) {
			memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo)); // Store the result in memo.
		}
		return memo.get(n); // Return the result from the memo.
	}

}


