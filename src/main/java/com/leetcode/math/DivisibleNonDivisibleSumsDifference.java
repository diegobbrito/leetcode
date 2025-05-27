package com.leetcode.math;

public class DivisibleNonDivisibleSumsDifference {

    // https://leetcode.com/problems/difference-between-sum-of-even-and-odd-indices-in-an-array/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int differenceOfSums(int n, int m) {

        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }
        return num1 - num2;

    }
}
