package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    //    https://leetcode.com/problems/valid-anagram/
//    Time Complexity O(n)
//    Space Complexity O(n)
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
        }

        for (Integer i: map.values()) {
            if(i != 0) return false;
        }

        return true;
    }

    //    Time Complexity O(n)
    //    Space Complexity O(n)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) != 0) return false;
        }

        return true;
    }
}
