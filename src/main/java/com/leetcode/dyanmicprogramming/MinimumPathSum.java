package com.leetcode.dyanmicprogramming;

public class MinimumPathSum {

//    https://leetcode.com/problems/minimum-path-sum/

    // Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
    // Space Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows + 1][cols + 1]; // Create a 2D array to store the minimum path sum

        for (int r = 0; r <= rows; r++) {
            for (int c = 0; c <= cols; c++) {
                dp[r][c] = Integer.MAX_VALUE; // Initialize the minimum path sum to infinity
            }
        }
        dp[rows - 1][cols] = 0; // Set the bottom-right cell to 0

        for (int r = rows - 1; r >= 0; r--) { // Iterate through the rows in reverse order
            for (int c = cols - 1; c >= 0; c--) { // Iterate through the columns in reverse order
                dp[r][c] = grid[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]); // Calculate the minimum path sum
            }
        }

        return dp[0][0];
    }

    // Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
    // Space Complexity: O(1)
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // Update the first row
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // Update the first column
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // Update the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    //Brute Force
    // Time complexity: O(2^(m+n)), where m is the number of rows and n is the number of columns in the grid.
    // Space complexity: O(m+n)
    int min;

    public int minPathSum3(int[][] grid) {
        min = Integer.MAX_VALUE;
        int count = 0;
        dfs(grid, 0, 0, count);
        return min;
    }

    private void dfs(int[][] grid, int row, int col, int count) {
        if (row >= grid.length && col >= grid[0].length)
            return;

        if (row < grid.length && col < grid[0].length) {
            count += grid[row][col];
            dfs(grid, row, col + 1, count);
            dfs(grid, row + 1, col, count);
        } else if (row < grid.length) {
            dfs(grid, row + 1, col, count);
        } else {
            dfs(grid, row, col + 1, count);
        }

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            min = Math.min(min, count);
        }
    }
}
