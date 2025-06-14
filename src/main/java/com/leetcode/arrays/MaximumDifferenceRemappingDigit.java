package com.leetcode.arrays;

public class MaximumDifferenceRemappingDigit {

    // https://leetcode.com/problems/maximum-difference-remapping-digit
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int minMaxDifference(int num) {
        String strNum = String.valueOf(num);
        char[] digits = strNum.toCharArray();

        char maxDigit = '9';
        char minDigit = '0';

        for (char digit : digits) {
            if (digit != '9') {
                maxDigit = digit;
                break;
            }
        }

        for (char digit : digits) {
            if (digit != '0') {
                minDigit = digit;
                break;
            }
        }

        String maxStr = strNum.replace(maxDigit, '9');
        String minStr = strNum.replace(minDigit, '0');

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
