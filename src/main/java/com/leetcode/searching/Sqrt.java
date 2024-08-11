package com.leetcode.searching;

public class Sqrt {
    //    https://leetcode.com/problems/sqrtx/
    public int mySqrt(int x) {
        if (x == 1) return 1;

        int left = 1, right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long result = (long) mid * mid;
            if (result == x) return mid;
            else if (result > x || result < 0) {
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return left - 1;
    }
}
