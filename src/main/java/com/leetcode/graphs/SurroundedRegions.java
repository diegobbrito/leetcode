package com.leetcode.graphs;

public class SurroundedRegions {

    // https://leetcode.com/problems/surrounded-regions/
    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                dfs(board, row - 1, i);
            }
        }

        for (int i = 1; i < row - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                else if (board[r][c] == '#')
                    board[r][c] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O') {

            board[r][c] = '#';

            dfs(board, r + 1, c);
            dfs(board, r, c + 1);
            dfs(board, r - 1, c);
            dfs(board, r, c - 1);
        }

    }
}
