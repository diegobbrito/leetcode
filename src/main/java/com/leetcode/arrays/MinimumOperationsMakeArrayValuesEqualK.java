package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsMakeArrayValuesEqualK {

    //    https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal-to-k/
    //Time complexity: O(n)
    //Space complexity: O(n)

    public int minOperations(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > k) set.add(num);
            if (num < k) return -1;
        }

        return set.size();

    }
}
