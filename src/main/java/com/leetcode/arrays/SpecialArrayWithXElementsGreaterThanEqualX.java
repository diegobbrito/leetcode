package com.leetcode.arrays;

public class SpecialArrayWithXElementsGreaterThanEqualX {

    //https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public int specialArray(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }
            if (count == i) {
                return i;
            }
        }
        return -1;
    }
}
