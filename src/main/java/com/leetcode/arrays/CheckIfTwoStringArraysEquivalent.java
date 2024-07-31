package com.leetcode.arrays;

public class CheckIfTwoStringArraysEquivalent {
    //    https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String word : word1) {
            sb1.append(word);
        }
        for (String word : word2) {
            sb2.append(word);
        }
        return sb1.toString().contentEquals(sb2);
    }
}
