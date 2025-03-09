package com.leetcode.arrays;

import java.util.List;

public class Array2D {

//    https://www.hackerrank.com/challenges/2d-array/problem
//    Time complexity: O(1), Space complexity: O(1)

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        int[] col = new int[]{0, 1, 2};
        int[] row = new int[]{0, 1, 2};
        for (int i = 0; i < 16; i++) {
            max = Math.max(max, sum(arr, col, row));
            if (col[2] == 5) {
                col = new int[]{0, 1, 2};
                row[0]++;
                row[1]++;
                row[2]++;
            } else {
                col[0]++;
                col[1]++;
                col[2]++;
            }
        }

        return max;
    }

    private static int sum(List<List<Integer>> arr, int[] col, int[] row) {
        int sum = 0;
        sum += arr.get(row[0]).get(col[0]);
        sum += arr.get(row[0]).get(col[1]);
        sum += arr.get(row[0]).get(col[2]);
        sum += arr.get(row[1]).get(col[1]);
        sum += arr.get(row[2]).get(col[0]);
        sum += arr.get(row[2]).get(col[1]);
        sum += arr.get(row[2]).get(col[2]);
        return sum;
    }
}
