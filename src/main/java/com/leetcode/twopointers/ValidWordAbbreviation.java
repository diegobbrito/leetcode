package com.leetcode.twopointers;

public class ValidWordAbbreviation {

    //    https://leetcode.com/problems/valid-word-abbreviation/
    // Time Complexity: O(n + m)
    // Space Complexity: O(1)

    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length(), m = abbr.length();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (abbr.charAt(j) == '0') return false;

            if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) == abbr.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                int subLen = 0;
                while (j < m && Character.isDigit(abbr.charAt(j))) {
                    subLen = subLen * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += subLen;
            }
        }

        return i == n && j == m;
    }
}
