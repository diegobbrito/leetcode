package com.leetcode.twopointers;

public class ReverseWordsStringIII {
    private static void reverse(char[] words, int left, int right) {
        char[] newWords = new char[right - left + 1];
        int index = 0;
        for (int i = right - 1; i >= left; i--) {
            newWords[index++] = words[i];
        }
        index = 0;
        for (int i = left; i < right; i++) {
            words[i] = newWords[index++];
        }
    }

    //Time Complexity: O(n)
//Space Complexity: O(n)
    public String reverseWords(String s) {

        int left = 0;
        char[] words = s.toCharArray();
        int size = s.length();
        for (int right = 0; right < size; right++) {
            if (words[right] == ' ') {
                reverse(words, left, right);
                left = right + 1;
            } else if (right == size - 1) {
                reverse(words, left, right + 1);
            }
        }
        return new String(words);
    }
}
