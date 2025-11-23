package com.leetcode.math;

public class FindMinimumOperationsMakeAllElementsDivisibleThree {

//    https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three
//    Time Complexity O(n)
//    Space Complexity O(1)
    public int minimumOperations(int[] nums) {
        int result = 0;

        for(int num : nums){
            if(num % 3 != 0){
                result++;
            }
        }
        return result;
    }
}
