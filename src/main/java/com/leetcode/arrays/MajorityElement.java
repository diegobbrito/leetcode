package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    //    https://leetcode.com/problems/majority-element/
//    Time Complexity O(2.n) = O(n)
//    Memory Complexity O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int majority = 0;
        int response = nums[0];
        for (int num : nums) {
            if (map.get(num) > majority) {
                majority = map.get(num);
                response = num;
            }
        }
        return response;
    }

    //    Time Complexity O(n) = O(n)
    //    Memory Complexity O(1)
    public int majorityElement2(int[] nums) {
        int majority = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                majority = num;
            count += num == majority ? 1 : -1;
        }
        return majority;
    }


}
