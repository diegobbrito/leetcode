package com.leetcode.twopointers;

public class MergeStringsAlternately {
    //    https://leetcode.com/problems/merge-strings-alternately/
//    Time Complexity O(n+m)
//    Space Complexity O(1)
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0, j = 0;

        StringBuilder sb = new StringBuilder();
        while (i < len1 && j < len2) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        while (i < len1) {
            sb.append(word1.charAt(i++));
        }
        while (j < len2) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
