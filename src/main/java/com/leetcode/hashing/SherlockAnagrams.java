package com.leetcode.hashing;

import java.util.HashMap;
import java.util.Map;

public class SherlockAnagrams {

//    https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

    //Time complexity: O(n^3), Space complexity: O(1)
    public static int sherlockAndAnagrams(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) { // i is the length of the substring
            for (int j = 0; j < s.length() - i; j++) { // j is the starting index of the substring
                String s1 = s.substring(j, j + i); // s1 is the substring
                for (int k = j + 1; k < s.length() - i + 1; k++) { // k is the starting index of the second substring
                    String s2 = s.substring(k, k + i); // s2 is the second substring
                    if (isAnagram(s1, s2)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }

    private static boolean isAnagram2(String s1, String s2) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            var value = count.get(c);
            if (value == null) return false;
            count.put(c, value - 1);
        }
        for (int i : count.values()) {
            if (i != 0) return false;
        }
        return true;
    }
}
