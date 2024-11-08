package com.leetcode.slidingwindow;

public class FindFirstPalindromicStringArray {
    //    https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
//    Time Complexity O(n * m)
//    Space Complexity O(1)
    public String firstPalindrome(String[] words) {
        for (String word : words)
            if (isPalindromic(word))
                return word;
        return "";
    }

    private boolean isPalindromic(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left <= right) {
            if (word.charAt(left) != word.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
