package com.leetcode.arrays;

public class ApplyOperationsArray {

    //https://leetcode.com/problems/apply-operations-to-an-array
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public int[] applyOperations(int[] nums) {
        int[] result = new int[nums.length];

        int r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                result[r++] = nums[i];
            }
        }
        if (nums[nums.length - 1] != 0) {
            result[r] = nums[nums.length - 1];
        }

        return result;
    }
}
