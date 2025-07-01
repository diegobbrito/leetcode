package com.leetcode.arrays;

public class FindOriginalTypedStringI {

    //https://leetcode.com/problems/find-the-original-typed-string-i
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public int possibleStringCount(String word) {
        int result = 1;
        for (int l = 0, r = 1; r < word.length(); r++) {
            while (r < word.length() && word.charAt(r) == word.charAt(l)) {
                r++;
                result++;
            }
            l = r;
        }
        return result;
    }
}
