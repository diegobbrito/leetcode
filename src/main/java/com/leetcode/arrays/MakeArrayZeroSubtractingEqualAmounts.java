package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class MakeArrayZeroSubtractingEqualAmounts {

    //    https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
//    Time: O(n2), Space: O(1)
    public int minimumOperations(int[] nums) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > 0)
                min = Math.min(min, num);
        }
        while (hasMoreThanZeros(nums)) {
            int newMin = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                nums[i] -= min;
                if (nums[i] > 0)
                    newMin = Math.min(newMin, nums[i]);
            }
            min = newMin;

            count++;
        }
        return count;
    }

    private boolean hasMoreThanZeros(int[] nums) {
        for (int num : nums) {
            if (num > 0)
                return true;
        }
        return false;
    }

    //    Time: O(n), Space: O(n)
    public int minimumOperations2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0)
                set.add(num);
        }
        return set.size();
    }
}
