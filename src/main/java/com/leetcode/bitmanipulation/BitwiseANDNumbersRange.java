package com.leetcode.bitmanipulation;

public class BitwiseANDNumbersRange {

//    https://leetcode.com/problems/bitwise-and-of-numbers-range/

    // >> is the right shift operator. It shifts the bits of the number to the right by the number of bits specified.
    // << is the left shift operator. It shifts the bits of the number to the left by the number of bits specified.
    // & is the bitwise AND operator. It performs the logical AND operation on the bits of the two numbers.
    // &= is the bitwise AND assignment operator. It performs the bitwise AND operation on the two numbers and assigns the result to the left operand.
    // |= is the bitwise OR assignment operator. It performs the bitwise OR operation on the two numbers and assigns the result to the left operand.
    // ^= is the bitwise XOR assignment operator. It performs the bitwise XOR operation on the two numbers and assigns the result to the left operand.
    // ~ is the bitwise NOT operator. It inverts the bits of the number, i.e., it changes 1 to 0 and 0 to 1.
    // >>> is the unsigned right shift operator. It shifts the bits of the number to the right by the number of bits specified, and fills the leftmost bits with zeros.

    // Time complexity: O(1)
    // Space complexity: O(1)
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0; // count the number of shifts
        while (left != right) { // if left and right are not equal, shift both left and right to the right
            left >>= 1; // shift left to the right
            right >>= 1; // shift right to the right
            count++; // increment count
        }
        return left << count; // return left shifted to the left by count
    }

    //Brute Force
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int rangeBitwiseAnd2(int left, int right) {
        int res = left;
        for (int i = left + 1; i <= right; i++) {
            res &= i;
        }
        return res;
    }


}
