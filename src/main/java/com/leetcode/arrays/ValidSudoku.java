package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    //    https://leetcode.com/problems/valid-sudoku/
    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    var check = set.add(board[i][j]);
                    if (!check) return false;
                }
            }
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    var check = set.add(board[j][i]);
                    if (!check) return false;
                }
            }
        }

        if (!helper(board, 0, 3, 0, 3)) return false;
        if (!helper(board, 3, 6, 0, 3)) return false;
        if (!helper(board, 6, 9, 0, 3)) return false;

        if (!helper(board, 0, 3, 3, 6)) return false;
        if (!helper(board, 3, 6, 3, 6)) return false;
        if (!helper(board, 6, 9, 3, 6)) return false;

        if (!helper(board, 0, 3, 6, 9)) return false;
        if (!helper(board, 3, 6, 6, 9)) return false;
        if (!helper(board, 6, 9, 6, 9)) return false;


        return true;
    }

    static boolean helper(char[][] board, int a, int b, int c, int d) {
        Set<Character> set = new HashSet<>();
        for (int i = a; i < b; i++) {
            for (int j = c; j < d; j++) {
                if (board[i][j] != '.') {
                    var check = set.add(board[i][j]);
                    if (!check) return false;
                }
            }
        }
        return true;
    }

    ;
}
