package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {

//    https://leetcode.com/problems/divide-array-into-equal-pairs
//    Time complexity: O(n), Space complexity: O(n)

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i : map.values()) {
            if (i % 2 == 1) return false;
        }
        return true;

    }
}
