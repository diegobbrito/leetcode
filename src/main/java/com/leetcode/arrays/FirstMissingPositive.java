package com.leetcode.arrays;

import java.util.Arrays;

public class FirstMissingPositive {
    //    https://leetcode.com/problems/first-missing-positive/

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for (int num : nums)
            if (num == min) min++;
        return min;
    }

}
