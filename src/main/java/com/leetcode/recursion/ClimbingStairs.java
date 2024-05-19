package com.leetcode.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n <= 1){
			return n;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	// NEETCODE SOLUTION

	public int climbStairsOptimize(int n) {
		int one = 1;
		int two = 1;

		for (int i = 0; i < n - 1; i++){
			int temp = one;
			one = one + two;
			two = temp;
		}
		return one;
	}

	public int climbStairsBottomUp(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}



	public int climbStairsTopDownWithMemo(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);

		return climbStairsWithMemo(n - 1, memo) + climbStairsWithMemo(n - 2, memo);
	}

	private int climbStairsWithMemo(int n, int[] memo) {
		if (n < 0) return 0;
		if (n == 0 || n == 1) {
			memo[n] = 1;
			return memo[n];
		}
		if (memo[n] != -1) return memo[n];

		memo[n] = climbStairsWithMemo(n - 1, memo) + climbStairsWithMemo(n - 2, memo);
		return memo[n];
	}

	//LEETCODE SOLUTION
	public int climbStairs2(int n) {
		Map<Integer, Integer> memo = new HashMap<>();
		return climbStairs(n, memo);
	}

	private int climbStairs(int n, Map<Integer, Integer> memo) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (!memo.containsKey(n)) {
			memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
		}
		return memo.get(n);
	}
}


