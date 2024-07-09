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
}
