package com.leetcode.bitmanipulation;

public class FlippingBits {

//    https://www.hackerrank.com/challenges/flipping-bits/problem

    //Time complexity: O(1)
    //Space complexity: O(1)
    public static long flippingBits(long n) {

        return ~n & 0xFFFFFFFFL;//0xFFFFFFFFL is 32 bits of 1
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    public static long flippingBits2(long n) {
        return n ^ 4294967295L; // XOR with 4294967295L to flip the bits
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    public static long flippingBits3(long n) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result |= ((n >> i) & 1) ^ 1L << i; // XOR with 1L << i to flip the i-th bit
        }
        return result;
    }
}
