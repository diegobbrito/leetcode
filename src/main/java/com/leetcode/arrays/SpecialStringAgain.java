package com.leetcode.arrays;


public class SpecialStringAgain {
//    https://www.hackerrank.com/challenges/special-palindrome-again/problem

    //Time complexity: O(n)
    //Space complexity: O(n)
    public static long substrCount(int n, String s) {
        long count = 0;
        int[] freq = new int[n]; // frequency of each character
        int left = 0;
        while (left < n) {
            int right = left + 1;
            while (right < n && s.charAt(right) == s.charAt(left)) // count all same characters
                right++;
            int len = right - left;
            count += ((long) len * (len + 1)) / 2; // count all substrings with same characters
            freq[left] = len; // store the frequency of each character
            left = right; // move to the next character
        }
        for (int i = 1; i < n - 1; i++) { // check for all characters except the first and last
            if (s.charAt(i) == s.charAt(i - 1)) { // if the current character is the same as the previous one
                freq[i] = freq[i - 1]; // set the frequency of the current character to the frequency of the previous character
            }
            if (s.charAt(i - 1) == s.charAt(i + 1) && s.charAt(i) != s.charAt(i - 1)) { // if the previous and next characters are the same and the current character is different
                count += Math.min(freq[i - 1], freq[i + 1]); // add the minimum frequency of the previous and next characters to the count
            }
        }
        return count;
    }


}
