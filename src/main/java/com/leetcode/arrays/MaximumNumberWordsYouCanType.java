package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberWordsYouCanType {

    //    https://leetcode.com/problems/maximum-number-of-words-you-can-type/
    //    Time complexity: O(n * m) n - number of words, m - average length of a word
    //    Space complexity: O(k) k - number of broken letters

    public int canBeTypedWords(String text, String brokenLetters) {

        String[] words = text.split(" ");
        Set<Character> brokenLettersSet = new HashSet<>();

        for(char c : brokenLetters.toCharArray()){
            brokenLettersSet.add(c);
        }

        int result = 0;
        OUTER: for(String word : words){
            for(char c : word.toCharArray()){
                if(brokenLettersSet.contains(c)){
                    continue OUTER;
                }
            }
            result++;
        }
        return result;
    }
}
