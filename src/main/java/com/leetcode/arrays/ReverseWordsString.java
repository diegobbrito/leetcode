package com.leetcode.arrays;

public class ReverseWordsString {
//    https://leetcode.com/problems/reverse-words-in-a-string/

//    Time complexity: O(n)
//    Space complexity: O(n)

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            int end = i + 1;
            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            int start = i + 1;

            sb.append(s, start, end);
            if (i > 0) sb.append(" ");
        }

        return sb.toString().trim();

    }
}
