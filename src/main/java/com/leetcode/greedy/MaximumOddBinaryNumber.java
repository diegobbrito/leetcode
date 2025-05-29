package com.leetcode.greedy;

public class MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') count++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count - 1; i++) result.append('1');
        for (int i = 0; i < s.length() - count; i++) result.append('0');
        result.append('1');

        return result.toString();
    }
}
