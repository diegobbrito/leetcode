package com.leetcode.backtracing;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    // https://leetcode.com/problems/sudoku-solver/
    // Time complexity: O(9^(m*n))
    // Space complexity: O(1)

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num ||
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    // A brute force approach that only fills in cells that have a single possibility
    // Time complexity: O(9^(m*n))
    // Space complexity: O(1)
    public void solveSudokuBruteForce(char[][] board) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char n = board[i][j];
                if (n != '.') {
                    set.add("Row " + n + i);
                    set.add("Column " + n + j);
                    set.add("Block " + n + i / 3 + j / 3);
                    count++;
                }
            }
        }

        while (count < 81) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char n = board[i][j];
                    if (n == '.') {
                        Set<Integer> possible = new HashSet<>();
                        for (int k = 1; k < 10; k++) {
                            if (!set.contains("Row " + k + i) && !set.contains("Column " + k + j)
                                    && !set.contains("Block " + k + i / 3 + j / 3)) {
                                possible.add(k);
                                if(possible.size() > 1)
                                    break;
                            }
                        }
                        if (possible.size() == 1) {
                            board[i][j] = (char) (possible.iterator().next() + '0');
                            set.add("Row " + board[i][j] + i);
                            set.add("Column " + board[i][j] + j);
                            set.add("Block " + board[i][j] + i / 3 + j / 3);
                            count++;
                        }
                    }
                }
            }

        }
    }
}
