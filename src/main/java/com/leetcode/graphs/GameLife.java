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
}
