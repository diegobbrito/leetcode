package com.leetcode.arrays;

public class LengthLastWord {
    //    https://leetcode.com/problems/length-of-last-word/
//    Time Complexity O(1)
//    Memory Complexity O(n)
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(1)
    public int lengthOfLastWord2(String s) {
        int i = s.length() - 1; // Start pointer at the last digit
        int length = 0;
        while (s.charAt(i) == ' ') // Remove all empty spaces at the final of the string
            i--;
        // Check the size of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }
}
