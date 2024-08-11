package com.leetcode.searching;

public class SquaresSortedArray {
    //	https://leetcode.com/problems/squares-of-a-sorted-array/
//	Time Complexity O(n)
//	Memory Complexity O(n)
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, index = nums.length - 1, size = nums.length;
        int[] result = new int[size];
        while (left <= right)
            if (nums[left] * nums[left] > nums[right] * nums[right])
                result[index--] = nums[left] * nums[left++];
            else
                result[index--] = nums[right] * nums[right--];
        return result;
    }

}
