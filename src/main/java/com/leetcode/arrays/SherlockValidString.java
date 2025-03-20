package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class SherlockValidString {

//    https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

    //Time complexity: O(n)
    //Space complexity: O(n)

    public static String isValid(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> freqCount = new HashMap<>();


        for (int i : freq.values()) {
            freqCount.put(i, freqCount.getOrDefault(i, 0) + 1);
        }

        if (freqCount.size() == 1) {
            return "YES";
        } else if (freqCount.size() == 2) {
            int minFreq = Integer.MAX_VALUE, maxFreq = Integer.MIN_VALUE;
            for (int key : freqCount.keySet()) {
                minFreq = Math.min(minFreq, key);
                maxFreq = Math.max(maxFreq, key);
            }
            if ((freqCount.get(minFreq) == 1 && minFreq == 1) || (freqCount.get(maxFreq) == 1 && maxFreq - minFreq == 1)) {
                return "YES";
            }
        }
        return "NO";

    }
}

