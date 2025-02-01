package com.leetcode.arrays;

public class SpecialArrayI {
//    https://leetcode.com/problems/special-array-i/

    //    Time complexity: O(n)
//    Space complexity: O(1)
    public boolean isArraySpecial(int[] nums) {
        if (nums.length < 2) return true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2)
                return false;
        }

        return true;
    }
}
