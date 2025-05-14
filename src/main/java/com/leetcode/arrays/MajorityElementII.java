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

    // Time complexity: O(n)
    // Space complexity: O(1)

    public List<Integer> majorityElement2(int[] nums) {
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
            else if (count1 == 0) {
                count1 = 1;
                num1 = num;
            } else if (count2 == 0) {
                count2 = 1;
                num2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;
        }

        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (count1 > n / 3) res.add(num1);
        if (count2 > n / 3) res.add(num2);

        return res;
    }
}
