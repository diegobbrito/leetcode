package com.leetcode.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomNote {

    // https://www.hackerrank.com/challenges/ctci-ransom-note/problem
    // Time complexity: O(m + n), Space complexity: O(m)
    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here

        Map<String, Integer> map = new HashMap<>();
        for (String s : magazine) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : note) {
            if (!map.containsKey(s) || map.get(s) < 1) {
                System.out.println("No");
                return;
            }
            map.put(s, map.get(s) - 1);
        }

        System.out.println("Yes");
    }
}
