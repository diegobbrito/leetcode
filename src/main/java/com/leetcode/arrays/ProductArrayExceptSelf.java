package com.leetcode.arrays;

public class ProductArrayExceptSelf {
    //    https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int prefix = 1;
        int posfix = 1;
        for (int i = 0; i < length; i++) {
            result[i] = prefix; // Add the prefix value to the array
            prefix *= nums[i]; // Multiply the prefix for the value in the first array
        }
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= posfix; // Multiply the profix with the value in i
            posfix *= nums[i]; // Multiply the posfix value with the first array
        }
        return result;
    }
}
