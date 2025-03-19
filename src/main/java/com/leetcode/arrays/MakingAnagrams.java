package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

//    https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

    //Time complexity: O(n + m)
    //Space complexity: O(n + m)

    public static int makeAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : b.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        int count = 0;
        for (int c : map.values()) {
            if (c != 0) count += Math.abs(c);
        }
        return count;
    }
}
