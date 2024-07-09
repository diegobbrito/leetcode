package com.leetcode.dyanmicprogramming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return bruteForce(0, 0, m, n);
    }

    private int bruteForce(int r, int c, int rows, int cols) {
        if (r == rows && c == cols) {
            return 0;
        }
        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }

        return (bruteForce(r + 1, c, rows, cols) + (bruteForce(r, c + 1, rows, cols)));
    }


}
