package com.leetcode.arrays;

public class CheckIfTwoStringArraysEquivalent {
    //    https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
    // Time Complexity O(n)
    // Memory Complexity O(n)
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

    // Time Complexity O(n)
    // Memory Complexity O(1)
    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
//        Add pointers for index word and for index of the char
        int wordIndex1 = 0, wordIndex2 = 0;
        int arrIndex1 = 0, arrIndex2 = 0;
        while (arrIndex1 < word1.length && arrIndex2 < word2.length) {
            if (word1[arrIndex1].charAt(wordIndex1) != word2[arrIndex2].charAt(wordIndex2))
                return false;

            wordIndex1++;
            wordIndex2++;
//            Check if the pointer is at the last position of the word and update the word and char index
            if (wordIndex1 == word1[arrIndex1].length()) {
                arrIndex1++;
                wordIndex1 = 0;
            }
            if (wordIndex2 == word2[arrIndex2].length()) {
                arrIndex2++;
                wordIndex2 = 0;
            }
        }
//        Check if the words are at the last index
        return arrIndex1 == word1.length && arrIndex2 == word2.length;
    }
}
