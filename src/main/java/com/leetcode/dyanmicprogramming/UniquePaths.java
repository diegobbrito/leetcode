package com.leetcode.dyanmicprogramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        return dp(m, n);
    }

    private static int memoization(int r, int c, int rows, int cols, int[][] cache) {
        if (r == rows || c == cols)
            return 0;
        if (cache[r][c] > 0)
            return cache[r][c];

        if (r == rows - 1 && c == cols - 1)
            return 1;
        cache[r][c] = (memoization(r + 1, c, rows, cols, cache) + (memoization(r, c + 1, rows, cols, cache)));
        return cache[r][c];
    }

    // Dynamic programming: Time Complexity = O(m*n), SC = O(min(m,n))
    private static int dp(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                row[j] += row[j - 1];

        return row[n - 1];
    }

    private int bruteForce(int r, int c, int rows, int cols) {
        if (r == rows && c == cols)
            return 0;
        if (r == rows - 1 && c == cols - 1)
            return 1;
        return (bruteForce(r + 1, c, rows, cols) + (bruteForce(r, c + 1, rows, cols)));
    }

    // Dynamic programming: TC = O(m*n), SC = O(m*n)
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        //    Fill last row and last line with 1
        for (int i = 0; i < n; i++)
            dp[m - 1][i] = 1;
        for (int i = 0; i < m; i++)
            dp[i][n - 1] = 1;
        //    Fill the array with the sum of right and bottom for each position
        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
        return dp[0][0];    // Return first position
    }
}
