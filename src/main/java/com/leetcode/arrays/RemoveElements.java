package com.leetcode.arrays;

public class RemoveElements {

//    https://leetcode.com/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val)
                nums[count++] = nums[i];
        return count;
    }
}
