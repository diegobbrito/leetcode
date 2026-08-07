package com.leetcode.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

//    https://leetcode.com/problems/word-pattern/
//    Time Complexity O(n)
//    Space Complexity O(n)

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length)
            return false;

        Set<Character> set = new HashSet<>();
        Map<String, Character> map = new HashMap<>();
        int i = 0;
        for(String word : words){
            char c = pattern.charAt(i);
            if(map.containsKey(word)){
                if(map.get(word) != c){
                    return false;
                }
            } else {
                if(!set.add(c)) return false;
                map.put(word, c);
            }
            i++;
        }
        return true;
    }
}
