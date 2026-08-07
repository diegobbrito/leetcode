package com.leetcode.arrays;

public class CheckArrayIsSortedRotated {

//    https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
//    Time Complexity O(n)
//    Space Complexity O(1)

    public boolean check(int[] nums) {
        int length = nums.length;
        int i = 1;
        while(i < length && nums[i] >= nums[i - 1]){
            i++;
        }
        while(i < length && nums[i] <= nums[0]){
            i++;
        }
        return i == length;
    }
}
