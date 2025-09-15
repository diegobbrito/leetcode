package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberWordsYouCanType {

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
