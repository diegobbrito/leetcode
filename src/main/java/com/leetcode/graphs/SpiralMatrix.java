package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
//    https://leetcode.com/problems/spiral-matrix/

    //    Time Complexity O(n * m)
//    Space Complexity O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> response = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int count = m * n;
        int r = 0, c = 0;
        int cI = 0, rE = 1;

        while (count > 0) {
            while (count > 0 && c < n) {
                response.add(matrix[r][c]);
                c++;
                count--;
            }
            n--;
            c--;
            r++;
            while (count > 0 && r < m) {
                response.add(matrix[r][c]);
                r++;
                count--;
            }
            m--;
            r--;
            c--;
            while (count > 0 && c >= cI) {
                response.add(matrix[r][c]);
                c--;
                count--;
            }
            cI++;
            c++;
            r--;
            while (count > 0 && r >= rE) {
                response.add(matrix[r][c]);
                r--;
                count--;
            }
            r = rE++;
            c = cI;
        }
        return response;
    }

    //    Time Complexity O(n * m)
    //    Space Complexity O(1)
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> response = new ArrayList<>();
        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++)
                response.add(matrix[top][i]);
            top++;

            for (int i = top; i < bottom; i++)
                response.add(matrix[i][right - 1]);
            right--;

            if (left >= right || top >= bottom) break;

            for (int i = right - 1; i >= left; i--)
                response.add(matrix[bottom - 1][i]);
            bottom--;

            for (int i = bottom - 1; i >= top; i--)
                response.add(matrix[i][left]);
            left++;
        }
        return response;
    }
}
