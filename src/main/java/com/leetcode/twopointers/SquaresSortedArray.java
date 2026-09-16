package com.leetcode.twopointers;

public class SquaresSortedArray {

//    https://neetcode.io/problems/squares-of-a-sorted-array/
//    Time complexity: O(n)
//    Space complexity: O(n)

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        int[] result = new int[nums.length];
        while(i >= 0){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
            i--;
        }

        return result;
    }
}
