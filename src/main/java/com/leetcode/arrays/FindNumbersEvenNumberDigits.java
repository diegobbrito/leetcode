package com.leetcode.arrays;

public class FindNumbersEvenNumberDigits {

    //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
