package com.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
//    https://leetcode.com/problems/word-pattern/

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));

    }

    //    Time Complexity O(n)
//    Memory Complexity O(n)
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        int i = 0;
        for (char c : pattern.toCharArray()) {
            if (map.get(c) != null && !map.get(c).equals(words[i]))
                return false;
            map.put(c, words[i]);
            set.add(words[i]);
            i++;
        }
        return map.values().size() == set.size();
    }
    //    Time Complexity O(n)
    //    Memory Complexity O(n)

    public static boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        int size = pattern.length();
        for (int i = 0; i < size; i++) {
            //    Check if the key exist, if so, valid the value with the current value in words array
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            }
            //    If the key do not exist, check if the value are already in the map, if not, add to the map the key and value
            else {
                if (map.containsValue(words[i])) return false;
                map.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }
}
