package com.leetcode.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

    //https://www.hackerrank.com/challenges/frequency-queries/problem
    //Time complexity: O(n), Space complexity: O(n)

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> freqCount = new HashMap<>();

        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int value = query.get(1);

            if (operation == 1) {
                int oldFreq = freq.getOrDefault(value, 0);
                int newFreq = oldFreq + 1;
                freq.put(value, newFreq);

                freqCount.put(oldFreq, freqCount.getOrDefault(oldFreq, 0) - 1);
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
            } else if (operation == 2) {
                int oldFreq = freq.getOrDefault(value, 0);
                if (oldFreq > 0) {
                    int newFreq = oldFreq - 1;
                    freq.put(value, newFreq);

                    freqCount.put(oldFreq, freqCount.getOrDefault(oldFreq, 0) - 1);
                    freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
                }
            } else if (operation == 3) {
                result.add(freqCount.getOrDefault(value, 0) > 0 ? 1 : 0);
            }
        }

        return result;
    }
}
