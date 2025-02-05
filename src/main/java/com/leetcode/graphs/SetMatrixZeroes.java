package com.leetcode.graphs;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    //https://leetcode.com/problems/set-matrix-zeroes/

    //Time complexity: O(n * m)
    //Space complexity: O(n + m)
    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    col.add(j);
                    row.add(i);
                }
            }
        }
        for (int r : row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[r][j] = 0;
            }
        }
        for (int c : col) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][c] = 0;
            }
        }
    }

    //Time complexity: O(n + m)
    //Space complexity: O(1)
    //This solution is based on the fact that we can use the first row and first column to store the information about the rows and columns that need to be set to zero.
    //We need to use two additional variables to store the information about the first row and first column.
    public void setZeroesOptimize(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}
