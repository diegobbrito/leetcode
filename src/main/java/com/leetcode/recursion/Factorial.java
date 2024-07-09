package com.leetcode.recursion;

public class Factorial {
    public int factorialRecursion(int n) {
        if (n == 1) return 1;
        return n * factorialRecursion(n - 1);
    }

    public int factorial(int n) {
        int product = 1;
        while (n > 0) {
            product *= n;
            n--;
        }
        return product;
    }
}
