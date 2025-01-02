package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class CountVowelStringsRanges {
    //    https://leetcode.com/problems/count-vowel-strings-in-ranges/
//    Time complexity: O(n + m)
//    Space complexity: O(n)
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        int wordsSize = words.length;

        int[] preFix = new int[wordsSize];
        int sum = 0;
        for (int i = 0; i < wordsSize; i++) {
            if (vowel.contains(words[i].charAt(0)) && vowel.contains(words[i].charAt(words[i].length() - 1))) {
                sum++;
            }
            preFix[i] = sum;
        }

        int[] result = new int[queries.length];
        int i = 0;

        for (int[] query : queries) {
            int r = preFix[query[1]];
            int l = query[0] > 0 ? preFix[query[0] - 1] : 0;
            result[i++] = r - l;
        }

        return result;
    }


//    Set<Character> set;
//    public int[] vowelStrings(String[] words, int[][] queries) {
//        int[] result = new int[queries.length];
//        int i = 0;
//        set = new HashSet<>();
//        set.add('a');
//        set.add('e');
//        set.add('i');
//        set.add('o');
//        set.add('u');
//        for(int[] query : queries){
//            result[i++] = searchWords(words, query[0], query[1]);
//        }
//        return result;
//    }
//    private int searchWords(String[] words, int start, int end){
//        int count = 0;
//        for(int i = start; i <= end; i++){
//            String word = words[i];
//            if(set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1)))
//                count++;
//        }
//        return count;
//    }
}
