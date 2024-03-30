package com.leetcode.arrays;

public class RemoveDuplicates {

//    https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    public int remove(int[] nums){
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
