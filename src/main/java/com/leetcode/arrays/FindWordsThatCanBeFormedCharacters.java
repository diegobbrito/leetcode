package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedCharacters {
//    https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

    //    Time complexity: O(n + (m * k))
//    Space complexity: O(1)
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        for (String word : words) {
            Map<Character, Integer> curMap = new HashMap<>();
            result += word.length();
            for (char c : word.toCharArray()) {
                curMap.put(c, curMap.getOrDefault(c, 0) + 1);
                int a = map.getOrDefault(c, 0);
                int b = curMap.get(c);
                if (a < b) {
                    result -= word.length();
                    break;
                }
            }
        }
        return result;
    }

    //    Time complexity: O(n + (m * k))
//    Space complexity: O(1)
    public int countCharactersArray(String[] words, String chars) {
        int[] base = new int[26];
        for (char c : chars.toCharArray()) {
            base[c - 'a']++;
        }
        int result = 0;
        for (String word : words) {
            int[] cur = new int[26];
            result += word.length();
            for (char c : word.toCharArray()) {
                cur[c - 'a']++;
                if (base[c - 'a'] < cur[c - 'a']) {
                    result -= word.length();
                    break;
                }
            }
        }
        return result;
    }
}
