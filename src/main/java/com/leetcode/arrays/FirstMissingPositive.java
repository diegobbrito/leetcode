package com.leetcode.arrays;

import java.util.Arrays;

public class FirstMissingPositive {
    //    https://leetcode.com/problems/first-missing-positive/

    //    Time Complexity O(nlogn)
//    Memory Complexity (1)
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for (int num : nums)
            if (num == min) min++;
        return min;
    }

    //    Time Complexity O(2.n) -> O(n)
//    Memory Complexity (1)
    public int firstMissingPositive2(int[] nums) {
        // Initialize the index variable and get the size of the array
        int i = 0;
        int size = nums.length;

        // Start a loop to iterate through the array
        while (i < size) {
            // Check if the current number is positive, within the range of the array,
            // and not already in its correct position
            if (nums[i] > 0 && nums[i] <= size && nums[nums[i] - 1] != nums[i]) {
                // If so, swap the current number with the number at its correct position
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            } else {
                // If not, move to the next index
                i++;
            }
        }

        // After placing all the numbers in their correct positions,
        // find the first index where the number is not in its correct position
        for (int j = 0; j < size; j++) {
            if (nums[j] != j + 1) {
                // Return the first missing positive number
                return j + 1;
            }
        }

        // If all numbers are in their correct positions, return the next positive number
        return size + 1;
    }


}
