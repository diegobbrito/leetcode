package com.leetcode.math;

public class PlusOne {
//    https://leetcode.com/problems/plus-one/

    //    Time complexity: O(n), where n is the number of digits in the input array.
//    Space complexity: O(1)
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) { // if the digit is less than 9, we can increment it and return the array
                digits[i]++;
                break;
            }
            digits[i] = 0; // if the digit is 9, we set it to 0 and continue to the next digit
            if (i == 0) { // if we reach the first digit, we need to add a new digit to the array
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (int j = 0; j < digits.length; j++) {
                    result[j + 1] = digits[j];
                }
                return result;
            }
        }
        return digits;
    }
}
