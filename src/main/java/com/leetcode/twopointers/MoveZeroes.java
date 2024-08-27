package com.leetcode.twopointers;

import java.util.Stack;

public class MoveZeroes {
    //    https://leetcode.com/problems/move-zeroes/

    //    Memory Complexity O(n)
    //    Space Complexity O(1)

    public void moveZeroes(int[] nums) {
        int l = 0;
        int size = nums.length;
        // Move the non zeros numbers to the left
        for (int r = 0; r < size; r++) {
            if (nums[r] != 0) {
                var temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        }
    }

    //    Memory Complexity O(n)
//    Space Complexity O(1)
    public void moveZeroes1(int[] nums) {
        int i = 0, j = 0;
        int size = nums.length;
        while (j < size && i < size) {
            while (i < size && nums[i] != 0) {
                i++;
            }
            while (j < size && nums[j] == 0) {
                j++;
            }
            if (j < size && i < size && j > i) {
                var temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            j++;
        }
    }

    //    Memory Complexity O(n)
    //    Space Complexity O(n)
    public void moveZeroes2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                stack.push(nums[i]);
                nums[i] = 0;
            }
        }
        int size = stack.size();
        for (int i = size - 1; i >= 0; i--) {
            nums[i] = stack.pop();
        }
    }
}
