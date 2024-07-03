package com.leetcode.arrays;

public class ProductArrayExceptSelf {
    //    https://leetcode.com/problems/product-of-array-except-self/description/
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j)
                    sum *= nums[j];
            }
            result[i] = sum;
        }
        return result;
    }
}
