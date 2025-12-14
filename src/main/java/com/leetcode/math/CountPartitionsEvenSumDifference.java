package com.leetcode.math;

public class CountPartitionsEvenSumDifference {

//    https://leetcode.com/problems/count-partitions-with-even-sum-difference/
//    Time Complexity O(n)
//    Space Complexity O(1)

    public int countPartitions(int[] nums) {
        int right = 0;
        for (int num : nums){
            right += num;
        }
        int left = 0;
        int result = 0;
        for(int i = 0; i < nums.length - 1; i++){
            left += nums[i];
            right -= nums[i];
            if((left - right) % 2 == 0){
                result++;
            }
        }
        return result;
    }
}
