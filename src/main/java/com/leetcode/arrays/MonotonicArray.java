package com.leetcode.arrays;

public class MonotonicArray {
    //    https://leetcode.com/problems/monotonic-array/
    //    Time Complexity O(n)
    //    Memory Complexity O(1)
    public static boolean isMonotonic(int[] nums) {
        int size = nums.length;
        if (size == 1) return true;
        int countGreater = 0;
        int countLess = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1])
                countGreater++;
            if (nums[i] <= nums[i + 1])
                countLess++;
        }
        return (size - 1 == countGreater || size - 1 == countLess);
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(1)
    public static boolean isMonotonic2(int[] nums) {
        int size = nums.length;
        if (size == 1) return true;

        int i = 0;
        while (i < size - 1 && nums[i] >= nums[i + 1]) {
            i++;
        }
        if (i == size - 1) return true;
        i = 0;
        while (i < size - 1 && nums[i] <= nums[i + 1]) {
            i++;
        }
        return i == size - 1;
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(1)
    public static boolean isMonotonic3(int[] nums) {
        int lastIndex = nums.length - 1;
        if (nums[lastIndex] < nums[0]) {
            for (int i = 0; i < lastIndex; i++)
                if (nums[i] < nums[i + 1])
                    return false;
        } else
            for (int i = 0; i < lastIndex; i++)
                if (nums[i] > nums[i + 1])
                    return false;

        return true;
    }
}
