package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class CountNumberConsistentStrings {

//    https://neetcode.io/problems/count-the-number-of-consistent-strings/
//    Time complexity: O(n * m) where n is the length of words and m is the average length of each word
//    Space complexity: O(k) where k is the length of allowed

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char c : allowed.toCharArray()){
            set.add(c);
        }
        int result = words.length;
        for(String word : words){
            for(char c : word.toCharArray()){
                if(!set.contains(c)){
                    result--;
                    break;
                }
            }
        }
        return result;
    }
}
