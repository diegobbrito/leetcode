package com.leetcode.math;

public class CountTotalNumberColoredCells {

    // https://leetcode.com/problems/count-total-number-of-colored-cells/
    // Time Complexity O(n)
    // Space Complexity O(1)

    public long coloredCells(int n) {
        long sum = 1;
        for(int i = 1; i < n; i++){
            sum += i * 4;
        }
        return sum;    
    }

    // Time Complexity O(1)
    // Space Complexity O(1)
    public long coloredCells2(int n) {
        long sum = 2L * (n -1) * n;
        return 1L + sum;
    }


}