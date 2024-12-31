package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;


public class SetMismatch {
//    https://leetcode.com/problems/set-mismatch/

    //    Time Complexity: O(n)
//    Space Complexity: O(n)
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                result[0] = num;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (set.add(i))
                result[1] = i;
        }
        return result;
    }

    //    Time Complexity: O(n)
//    Space Complexity: O(1)
    public int[] findErrorNums2(int[] nums) {
        int[] result = new int[2];
        for (int num : nums) {
            int index = Math.abs(num) - 1; //index starts from 0
            if (nums[index] < 0)
                result[0] = Math.abs(num); //duplicate
            else
                nums[index] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result[1] = i + 1;
        }
        return result;
    }
}
