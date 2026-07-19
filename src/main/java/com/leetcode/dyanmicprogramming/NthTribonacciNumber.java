package com.leetcode.dyanmicprogramming;

public class NthTribonacciNumber {

//    https://neetcode.io/problems/n-th-tribonacci-number/

//    Time Complexity O(n)
//    Space Complexity O(1)

    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n < 3) return 1;

        int one = 0;
        int two = 1;
        int three = 1;

        for(int i = 2; i < n; i++){
            int sum = one + two + three;
            one = two;
            two = three;
            three = sum;
        }

        return three;
    }
}
