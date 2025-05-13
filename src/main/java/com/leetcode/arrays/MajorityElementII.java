package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    //https://leetcode.com/problems/majority-element-ii/
    // Time complexity: O(n)
    // Space complexity: O(n)

    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length / 3;
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();

        for (int num : count.keySet()) {
            if (count.get(num) > n) {
                result.add(num);
            }
        }

        return result;

    }
}
