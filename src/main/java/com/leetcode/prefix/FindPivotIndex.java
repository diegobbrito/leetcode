package com.leetcode.prefix;

public class FindPivotIndex {
//    https://neetcode.io/problems/find-pivot-index/
//    Time Complexity O(n)
//    Memory Complexity O(n)

    public int pivotIndex(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] posfix = new int[nums.length];
        int prefixSum = 0;
        int posfixSum = 0;

        for(int i = 0, j = nums.length - 1; i < nums.length; i++, j--){
            prefixSum += nums[i];
            posfixSum += nums[j];
            prefix[i] = prefixSum;
            posfix[j] = posfixSum;
        }

        for(int i = 0; i < nums.length; i++){
            int left = i > 0 ? prefix[i - 1] : 0;
            int right = i < nums.length - 1 ? posfix[i + 1] : 0;
            if(left == right){
                return i;
            }
        }

        return -1;
    }
}
