package com.leetcode.twopointers;

public class ReverseWordsStringIII {

    private static void reverse(char[] words, int left, int right) {
        int l = left;
        int r = right;
        while (l < r) {
            char temp = words[l];
            words[l] = words[r];
            words[r] = temp;
            l++;
            r--;
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
                reverse(words, left, right - 1);
                left = right + 1;
            } else if (right == size - 1) {
                reverse(words, left, right);
            }
        }
        return new String(words);
    }
}
