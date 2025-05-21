package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctStringArray {
    //https://leetcode.com/problems/kth-distinct-string-in-an-array/
    // Time complexity: O(n)
    // Space complexity: O(n)

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> count = new HashMap<>();

        for (String s : arr) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        for (String s : arr) {
            if (count.get(s) == 1) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }

        return "";
    }
}
