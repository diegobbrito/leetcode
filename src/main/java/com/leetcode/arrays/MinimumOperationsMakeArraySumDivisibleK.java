package com.leetcode.arrays;

public class MinimumOperationsMakeArraySumDivisibleK {


//    Time Complexity O(n)
//    Space Complexity O(1)
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum % k;
    }
}
