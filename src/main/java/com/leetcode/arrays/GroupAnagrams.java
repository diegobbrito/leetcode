package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GroupAnagrams {
    public static void main(String[] args) {
        var response = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(response);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> response = new ArrayList<>();
        boolean[] cache = new boolean[strs.length];
        for (int i = 0; i < strs.length - 1; i++) {
            List<String> current = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (!cache[j]) {
                    if (isAnagram(strs[i], strs[j])) {
                        cache[j] = true;
                        cache[i] = true;
                        current.add(strs[i]);
                        current.add(strs[j]);
                    }
                }
            }
            if (!current.isEmpty())
                response.add(List.copyOf(current));
        }
        if (!cache[strs.length - 1]) {
            response.add(List.of(strs[strs.length - 1]));
        }

        return response;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer i : map.values()) {
            if (i != 0) return false;
        }

        return true;
    }
}
