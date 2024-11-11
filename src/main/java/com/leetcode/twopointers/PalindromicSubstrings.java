package com.leetcode.twopointers;

public class PalindromicSubstrings {
    //    https://leetcode.com/problems/palindromic-substrings/
//    Time complexity: O(n²)
//    Space complexity: O(1)
    public int countSubstrings(String s) {
        int result = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            result += getResult(s, i, i, size);
            result += getResult(s, i, i + 1, size);
        }
        return result;
    }

    private static int getResult(String s, int l, int r, int size) {
        int result = 0;
        while (l >= 0 && r < size && s.charAt(l) == s.charAt(r)) {
            result++;
            l--;
            r++;
        }
        return result;
    }

}
