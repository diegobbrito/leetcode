package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersMakeAllStringsEqual {
    //    https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal
//    Time complexity: O(n * m)
//    Space complexity: O(1)
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        for (Integer i : map.values()) {
            if (i % words.length != 0)
                return false;
        }
        return true;
    }

    //    Time complexity: O(n * m)
//    Space complexity: O(1)
    public boolean makeEqualOptimize(String[] words) {
        int[] arr = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                arr[c - 'a']++;
            }
        }
        int size = words.length;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % size != 0)
                return false;
        }
        return true;
    }
}
