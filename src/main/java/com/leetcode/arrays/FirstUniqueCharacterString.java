package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterString {
//    https://leetcode.com/problems/first-unique-character-in-a-string/

    //    Time Complexity - O(n)
    //    Space Complexity - O(1)
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    //    Time Complexity - O(n)
    //    Space Complexity - O(1)
    public int firstUniqCharHashMap(String s) {
        int n = s.length();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!count.containsKey(c))
                count.put(c, i);
            else
                count.put(c, n);
        }
        int res = n;
        for (int index : count.values()) {
            res = Math.min(res, index);
        }
        return res == n ? -1 : res;
    }
}
