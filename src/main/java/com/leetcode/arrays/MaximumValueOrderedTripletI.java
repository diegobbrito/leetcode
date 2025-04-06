package com.leetcode.arrays;

public class MaximumValueOrderedTripletI {

//    https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/

    //Time complexity: O(n^3)
    //Space complexity: O(1)

    public long maximumTripletValue(int[] nums) {

        long result = 0L;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    result = Math.max(result, ((long) nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return result;
    }
}
