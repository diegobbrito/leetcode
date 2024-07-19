package com.leetcode.bitmanipulation;

public class Number1Bits {
    //    OR = |
    //    AND = &
    //    XOR = ^
    //    Bit Manipulation
    //    Shift to left = << example: 001 -> 010 Multiply by 2
    //    Shift to right = >> example: 100 -> 010 Divide by 2
    //    Time complexity O(1) -> since its always a 32 bits int
    //    Memory complexity O(1)
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) { // check if the last digit is equal 1
                count++;
            }
            n = n >> 1; // Shift the number by one bit
        }
        return count;
    }

    //    Time complexity O(1) -> since its always a 32 bits int
    //    Memory complexity O(1)
    public int hammingWeight2(int n) {
        int count = 0;
        while (n > 0) {
            n &= n - 1; // remove the check for all 0s numbers
            count++;
        }
        return count;
    }
}
