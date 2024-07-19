package com.leetcode.bitmanipulation;

public class SumTwoIntegers {
    //    https://leetcode.com/problems/sum-of-two-integers/
    public int getSum(int a, int b) {
        // Loop until there are no more carries
        while (b != 0) {
            // Calculate carry:
            // bits where both a and b have 1s, shifted left to add in the next iteration
            int carry = (a & b) << 1;

            // Calculate the sum without carries using XOR
            a = a ^ b;

            // Update b to the carry value to add in the next iteration
            b = carry;
        }
        // When b is 0, all carries have been added and a contains the final sum
        return a;
    }
}
