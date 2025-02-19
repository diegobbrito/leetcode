package com.leetcode.bitmanipulation;

public class SingleNumberII {

//    https://leetcode.com/problems/single-number-ii/

    // Time Complexity: O(n), where n is the number of elements in the array.
    // Space Complexity: O(1)
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0; // Initialize two variables to store the XOR results
        for (int num : nums) { // Iterate through each number in the array
            ones = (ones ^ num) & ~twos; // XOR the current number with the ones variable and then AND the result with the negation of the twos variable
            twos = (twos ^ num) & ~ones; // XOR the current number with the twos variable and then AND the result with the negation of the ones variable
        }
        return ones; // Return the number that appears only once in the array
    }
}
