package com.leetcode.arrays;

public class ScoreString {

    // https://leetcode.com/problems/score-of-a-string
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return res;
    }
}
