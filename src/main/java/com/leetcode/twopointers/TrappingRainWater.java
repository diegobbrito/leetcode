package com.leetcode.twopointers;

public class TrappingRainWater {
    //    https://leetcode.com/problems/trapping-rain-water/
//    Time Complexity O(n)
//    Memory Complexity O(1)
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int res = 0;
        while (left < right) {
            if (maxRight > maxLeft) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                res += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                res += maxRight - height[right];
            }
        }
        return res;
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(n)
    public int trap2(int[] height) {
        int size = height.length;
        if (size == 0) return 0;
        int[] arr = new int[size];
        int max = height[0];
        for (int i = 0; i < size; i++) {
            arr[i] = Math.max(max, height[i]);
            max = arr[i];
        }
        max = height[size - 1];
        int res = 0;
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = Math.min(Math.max(max, height[i]), arr[i]) - height[i];
            max = Math.max(max, height[i]);
            if (arr[i] > 0) res += arr[i];
        }
        return res;
    }
}
