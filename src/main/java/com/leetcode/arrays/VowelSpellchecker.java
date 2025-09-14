package com.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {

    //    https://leetcode.com/problems/vowel-spellchecker/
    //    Time complexity: O(m + n)
    //    Space complexity: O(m)

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        String vowels = "[aeiou]";

        for(String word : wordlist){
            set.add(word);

            if(!map.containsKey(word.toLowerCase())){
                map.put(word.toLowerCase(), word);
            }
            String key = word.toLowerCase().replaceAll(vowels, "*");
            if(!map.containsKey(key)){
                map.put(key, word);
            }
        }
        String[] answer = new String[queries.length];
        for(int i = 0; i < queries.length; i++){
            String word = queries[i];
            if(set.contains(word)){
                answer[i] = word;
            } else if(map.containsKey(word.toLowerCase())){
                answer[i] = map.get(word.toLowerCase());
            } else {
                answer[i] = "";
                String key = word.toLowerCase().replaceAll(vowels, "*");
                if(map.containsKey(key))
                    answer[i] = map.get(key);
            }
        }
        return answer;
    }
}
