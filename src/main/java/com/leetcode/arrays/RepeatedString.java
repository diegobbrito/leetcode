package com.leetcode.arrays;

public class RepeatedString {

    // https://www.hackerrank.com/challenges/repeated-string/problem
    // Time complexity: O(n), Space complexity: O(1)
    public static long repeatedString(String s, long n) {
        long a = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') a++;
        }
        long divide = n / s.length();
        long left = n % s.length();
        a *= divide;
        if (left > 0) {
            for (int i = 0; i < left; i++) {
                if (s.charAt(i) == 'a') a++;
            }
        }
        return a;
    }
}
