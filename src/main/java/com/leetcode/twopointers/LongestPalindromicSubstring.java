package com.leetcode.twopointers;

public class LongestPalindromicSubstring {
//    https://leetcode.com/problems/longest-palindromic-substring/

    // Stores the length of the longest palindrome found
    private int longestPalindrome;
    // Stores the longest palindrome substring found
    private String result;

    // Function to find the longest palindromic substring
    public String longestPalindrome(String s) {
        result = ""; // Initialize result as an empty string
        longestPalindrome = 0; // Initialize the longest palindrome length to 0
        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            // Check for odd-length palindromes centered at the current character
            checkLongestPalindrome(s, left, right);
            // Check for even-length palindromes centered between the current and next character
            right = i + 1;
            checkLongestPalindrome(s, left, right);
        }
        // Return the longest palindromic substring
        return result;
    }

    // Helper function to expand around the center and check for palindromes
    private void checkLongestPalindrome(String s, int left, int right) {
        // Expand as long as characters on both sides are equal and within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // If the current palindrome is longer than the previously recorded longest one
            if (right - left + 1 > longestPalindrome) {
                longestPalindrome = right - left + 1; // Update the longest palindrome length
                result = s.substring(left, right + 1); // Update the result with the current palindrome
            }
            // Expand the window to check for a longer palindrome
            left--;
            right++;
        }
    }
}
