package com.leetcode.math;

public class Pow {

//    https://leetcode.com/problems/powx-n/

    //    Brute force solution
//    Time complexity: O(n), where n is the power.
//    Space complexity: O(1)
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1 || x == 1) return x;
        double result = x;
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                result *= x;
            }
        } else {
            for (int i = 0; i >= n; i--) {
                result /= x;
            }
        }
        return result;
    }

//Binary Exponentiation (Recursive)
//    Time complexity: O(logn), where n is the power.
//    Space complexity: O(logn), where n is the power.

    public double myPowOptimize(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        double result = helper(x, Math.abs((long) n));
        return n >= 0 ? result : 1 / result;
    }

    private double helper(double x, long n) {
        if (n == 0) return 1;
        var half = helper(x * x, n / 2);
        return n % 2 == 0 ? half : x * half;
    }

    //    Binary Exponentiation (Iterative)
//    Time complexity: O(logn), where n is the power.
//    Space complexity: O(1)
    public double myPowIterative(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        double result = 1;
        long power = Math.abs((long) n);
        while (power > 0) {
            if (power % 2 == 1) { // power & 1
                result *= x;
            }
            x *= x;
            power /= 2; // power >>= 1;
        }
        return n >= 0 ? result : 1 / result;
    }
}
