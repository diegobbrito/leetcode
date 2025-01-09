package com.leetcode.arrays;

public class CountingWordsWithGivenPrefix {
    //    https://leetcode.com/problems/counting-words-with-a-given-prefix/
//    Time complexity: O(n)
//    Space complexity: O(1)
    public int prefixCount(String[] words, String pref) {

        int result = 0;
        int size = pref.length();
        for (String word : words) {
            if (word.length() < size)
                continue;
            result++;
            for (int i = 0; i < size; i++) {
                if (pref.charAt(i) != word.charAt(i)) {
                    result--;
                    break;
                }
            }
        }

        return result;
    }

    //    Time complexity: O(n)
//    Space complexity: O(1)
    public int prefixCountOptimize(String[] words, String pref) {
        int result = 0;
        for (String word : words)
            if (word.startsWith(pref))
                result++;
        return result;
    }

    //    Use label to break the outer loop
//    Time complexity: O(n)
//    Space complexity: O(1)
    public int prefixCount2(String[] words, String pref) {
        int result = 0;
        int size = pref.length();
        OUT:
        for (String word : words) {
            if (word.length() < size)
                continue;
            for (int i = 0; i < size; i++) {
                if (pref.charAt(i) != word.charAt(i))
                    continue OUT;
            }
            result++;
        }

        return result;
    }
}
