package com.leetcode.graphs;

public class RotateImage {

    //https://leetcode.com/problems/rotate-image/
    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int top = left;
            int bottom = right;
            int size = right - left;
            for (int i = 0; i < size; i++) {
                int topLeft = matrix[top][left + i];

                matrix[top][left + i] = matrix[bottom - i][left];

                matrix[bottom - i][left] = matrix[bottom][right - i];

                matrix[bottom][right - i] = matrix[top + i][right];

                matrix[top + i][right] = topLeft;
            }
            left++;
            right--;
        }
    }
}