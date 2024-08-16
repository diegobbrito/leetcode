package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    //    https://leetcode.com/problems/isomorphic-strings/
//    Time Complexity O(n)
//    Memory Complexity O(n)
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (map.get(s.charAt(i)) != null) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else if (map.containsValue(t.charAt(i)))
                return false;
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
