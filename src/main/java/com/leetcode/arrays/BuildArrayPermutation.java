package com.leetcode.arrays;

public class BuildArrayPermutation {

    //https://leetcode.com/problems/build-array-from-permutation/
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[nums[i]];
        }

        return result;
    }
}
