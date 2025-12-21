package com.leetcode.arrays;

public class CountSquareSumTriples {

//    https://leetcode.com/problems/count-square-sum-triples/
//    Time Complexity O(n2)
//    Space Complexity O(1)


    public int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int sum = a * a + b * b;

                int sqrt = (int) Math.sqrt(sum);

                if (sqrt * sqrt == sum && sqrt <= n) {
                    count++;
                }
            }
        }

        return count;
    }
}
