package com.leetcode.twopointers;

public class ValidPalindromeII {
//    https://leetcode.com/problems/valid-palindrome-ii/

    //    Time Complexity O(n)
//    Space Complexity O(1)
    public static boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return isPalindrome(s.substring(l + 1, r + 1)) || isPalindrome(s.substring(l, r));
            l++;
            r--;
        }
        return true;
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
