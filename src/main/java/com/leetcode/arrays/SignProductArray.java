package com.leetcode.arrays;

public class SignProductArray {
    //    https://leetcode.com/problems/sign-of-the-product-of-an-array/
//    Time Complexity O(n)
//    Memory Complexity O(1)
    public int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) result *= -1;
        }
        return result;
    }
}
