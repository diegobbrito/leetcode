package com.leetcode.arrays;

public class NumArray {
//    https://leetcode.com/problems/range-sum-query-immutable/

    private final int[] prefix;

    //Time Complexity O(n)
    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        this.prefix = nums;
    }

    //Time Complexity O(1)
    public int sumRange(int left, int right) {
        if (left == 0) return prefix[right];
        return prefix[right] - prefix[left - 1];
    }
}


//public class NumArray {
//    int[] nums;
//
//    //Time Complexity O(1)
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//    //Time Complexity O(n)
//    public int sumRange(int left, int right) {
//        int sum = 0;
//        for(int i = left; i <= right; i++){
//            sum += this.nums[i];
//        }
//        return sum;
//    }
//}
