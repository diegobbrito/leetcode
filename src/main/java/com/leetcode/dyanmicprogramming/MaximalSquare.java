package com.leetcode.dyanmicprogramming;

public class MaximalSquare {

//    https://leetcode.com/problems/maximal-square/

    // Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
    // Space Complexity: O(n), where n is the number of columns in the matrix.
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];
        int maxSquare = 0;

        for (int r = m - 1; r >= 0; r--) {
            int prev = 0;
            for (int c = n - 1; c >= 0; c--) {
                int temp = dp[c];
                if (matrix[r][c] == '1') {
                    dp[c] = 1 + Math.min(dp[c], Math.min(dp[c + 1], prev));
                    maxSquare = Math.max(maxSquare, dp[c]);
                } else {
                    dp[c] = 0;
                }
                prev = temp;
            }
        }

        return maxSquare * maxSquare;
    }
}
