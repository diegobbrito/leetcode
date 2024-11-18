package com.leetcode.twopointers;

public class SortArrayByParity{
    //https://leetcode.com/problems/sort-array-by-parity/
    //Time Complexity O(n)
    //Memory Complexity O(n)
    public int[] sortArrayByParity(int[] nums) {
        int size = nums.length;
        int []result = new int[size];
        int left = 0;
        int right = size - 1;
        for(int i = 0; i < size; i++){
            if(nums[i] % 2 == 0)
                result[left++] = nums[i];
            else
                result[right--] = nums[i];
        }
        return result;
    }

    //Time Complexity O(n)
    //Memory Complexity O(1)
    public int[] sortArrayByParity2(int[] nums) {
        int size = nums.length;
        int left = 0;
        for(int right = 0; right < size; right++){
            if(nums[right] % 2 == 0){
                var temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

}