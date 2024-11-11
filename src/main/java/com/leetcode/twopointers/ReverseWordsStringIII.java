package com.leetcode.twopointers;

public class ReverseWordsStringIII {

//    https://leetcode.com/problems/reverse-words-in-a-string-iii/

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public String reverseWords(String s) {
        char[] words = s.toCharArray();
        int left = 0;
        int right = 0;
        int size = s.length();
        while (right < size) {
            if (words[right] == ' ') {
                reverse(words, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        reverse(words, left, right - 1);
        return new String(words);
    }

    private static void reverse(char[] words, int l, int r) {
        while (l < r) {
            char temp = words[l];
            words[l++] = words[r];
            words[r--] = temp;
        }
    }


}
