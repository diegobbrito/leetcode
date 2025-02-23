package com.leetcode.graphs;

public class GameLife {

    //https://leetcode.com/problems/game-of-life/
    //Time complexity: O(n*m)
    //Space complexity: O(n*m)
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] copy = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                updateCell(copy, board, i, j, rows, cols);
            }
        }
    }

    private void updateCell(int[][] base, int[][] board, int i, int j, int rows, int cols) {
        int num = base[i][j];
        int count = 0;

        if (i + 1 < rows && base[i + 1][j] == 1) count++;
        if (i - 1 >= 0 && base[i - 1][j] == 1) count++;
        if (j + 1 < cols && base[i][j + 1] == 1) count++;
        if (j - 1 >= 0 && base[i][j - 1] == 1) count++;

        if (i + 1 < rows && j - 1 >= 0 && base[i + 1][j - 1] == 1) count++;
        if (i + 1 < rows && j + 1 < cols && base[i + 1][j + 1] == 1) count++;
        if (i - 1 >= 0 && j + 1 < cols && base[i - 1][j + 1] == 1) count++;
        if (i - 1 >= 0 && j - 1 >= 0 && base[i - 1][j - 1] == 1) count++;

        if (num == 1) {
            if (count < 2 || count > 3)
                board[i][j] = 0;
        } else {
            if (count == 3)
                board[i][j] = 1;
        }
    }

    class Solution {
        // Time complexity: O(n*m)
        // Space complexity: O(1)
        public void gameOfLife(int[][] board) {
            int rows = board.length;
            int cols = board[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int count = countLiveNeighbors(board, i, j, rows, cols);

                    if (board[i][j] == 1) {
                        // Cell dies if it has less than 2 or more than 3 live neighbors
                        if (count < 2 || count > 3) {
                            board[i][j] = -1; // Mark as "was alive, now dead"
                        }
                    } else {
                        // Dead cell becomes alive if exactly 3 live neighbors
                        if (count == 3) {
                            board[i][j] = 2; // Mark as "was dead, now alive"
                        }
                    }
                }
            }

            // Final pass: Convert markers back to 0s and 1s
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == -1) board[i][j] = 0; // Dead
                    if (board[i][j] == 2) board[i][j] = 1; // Alive
                }
            }
        }

        private int countLiveNeighbors(int[][] board, int i, int j, int rows, int cols) {
            int count = 0;
            int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

            for (int[] dir : directions) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                    // A cell is alive if it's 1 or -1 (because -1 means "was alive")
                    if (Math.abs(board[ni][nj]) == 1) count++;
                }
            }
            return count;
        }

    }
}
