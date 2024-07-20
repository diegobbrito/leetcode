package com.leetcode.bitmanipulation;

public class ReverseBits {
    //    https://leetcode.com/problems/reverse-bits/
    public int reverseBits(int n) {
        // Initialize the result to 0, which will hold the reversed bits
        int result = 0;

        // Loop through each of the 32 bits of the integer
        for (int i = 0; i < 32; i++) {
            // Right shift the input number 'n' by 'i' positions and extract the least significant bit
            var bit = (n >> i) & 1;

            // Left shift the extracted bit to its new reversed position and OR it with the result
            // This places the bit in the correct position in the reversed result
            result = result | (bit << (31 - i));
        }

        // Return the result which now contains the reversed bits
        return result;
    }

}
