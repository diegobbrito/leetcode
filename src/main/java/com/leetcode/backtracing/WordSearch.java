package com.leetcode.backtracing;

public class WordSearch {
    //    https://leetcode.com/problems/word-search/
//    Time Complexity: O(m×n×4^L) where L is the length of word
//    The outer loop has a time complexity of O(m×n).
//    Space Complexity: O(L) where L is the length of word
    String word;
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (dfs(r, c, board, 0)) return true;
        return false;
    }

    private boolean dfs(int row, int col, char[][] board, int index) {
        if (index == word.length()) // Base case: if index is equal to word length, we have found the word
            return true;
        // Check boundaries and character match
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index))
            return false;

        // Mark the cell as visited by temporarily changing its value
        board[row][col] += 100;
        // Explore all 4 possible directions (left, right, up, down)
        boolean found = dfs(row + 1, col, board, index + 1)
                || dfs(row - 1, col, board, index + 1)
                || dfs(row, col + 1, board, index + 1)
                || dfs(row, col - 1, board, index + 1);
        // Backtrack by restoring the original value of the cell
        board[row][col] -= 100;

        return found;
    }
}
