package com.leetcode.arrays;

public class IntegerRoman {
//    https://leetcode.com/problems/integer-to-roman/

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    //    Time complexity: O(1)
    //    Space complexity: O(1)
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    // Time complexity: O(1)
// Space complexity: O(1)
    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            while (values[index] > num) {
                index++;
            }
            num -= values[index];
            sb.append(symbols[index]);
        }
        return sb.toString();
    }

    //    Time complexity: O(1)
//    Space complexity: O(1)
    public String intToRoman3(int num) {

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num > 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num > 900) {
                sb.append("CM");
                num -= 900;
            } else if (num > 500) {
                sb.append("D");
                num -= 500;
            } else if (num > 400) {
                sb.append("CD");
                num -= 400;
            } else if (num > 100) {
                sb.append("C");
                num -= 100;
            } else if (num > 90) {
                sb.append("XC");
                num -= 90;
            } else if (num > 50) {
                sb.append("L");
                num -= 50;
            } else if (num > 40) {
                sb.append("XL");
                num -= 40;
            } else if (num > 10) {
                sb.append("X");
                num -= 10;
            } else if (num > 9) {
                sb.append("IX");
                num -= 9;
            } else if (num > 5) {
                sb.append("V");
                num -= 5;
            } else if (num > 4) {
                sb.append("IV");
                num -= 4;
            } else {
                sb.append("I");
                num -= 1;
            }
        }
        return sb.toString();
    }
}
