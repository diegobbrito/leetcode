package com.leetcode.arrays;

public class StringToInteger {
    //    https://leetcode.com/problems/string-to-integer-atoi/
//    Time complexity: O(n)
//    Space complexity:O(1)
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean negative = s.charAt(0) == '-';
        if (negative || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        while (s.startsWith("0")) {
            s = s.substring(1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                s = s.substring(0, i);
            }
        }
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() > 10) s = s.substring(0, 11);
        long longResult = Long.parseLong(s);

        if (longResult > Integer.MAX_VALUE) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        int result = (int) longResult;

        return negative ? -result : result;
    }
}
