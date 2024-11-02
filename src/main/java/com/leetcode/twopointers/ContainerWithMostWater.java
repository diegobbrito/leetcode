package com.leetcode.twopointers;

public class ContainerWithMostWater {

    //    https://leetcode.com/problems/container-with-most-water/
//    Time Complexity O(n)
//    Memory Complexity O(1)
    public int maxArea(int[] height) {
        // Initialize two pointers: left starting from the beginning and right from the end.
        int left = 0, right = height.length - 1;

        // Variable to keep track of the maximum water area found.
        int max = 0;

        // Continue looping while the left pointer is less than the right pointer.
        while (left < right) {
            // Calculate the current water area, which is the width (right - left)
            // multiplied by the height of the shorter line (Math.min(height[left], height[right])).
            int water = (right - left) * Math.min(height[left], height[right]);
            // Update max if the current water area is larger than the previously recorded maximum.
            max = Math.max(max, water);
            // Move the pointer that is at the shorter line inward to try to find a larger container.
            if (height[left] < height[right])
                left++;  // If the left line is shorter, move it to the right.
            else
                right--;  // Otherwise, move the right pointer to the left.
        }
        // Return the maximum area found.
        return max;
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(1)
    public int maxAreaOptimize(int[] height) {
        // Initialize two pointers: left starting from the beginning and right from the end.
        int left = 0, right = height.length - 1, max = 0;
        // Continue looping while the left pointer is less than the right pointer.
        while (left < right) {
            // Get the height of the shorter line between the two pointers.
            int h = Math.min(height[left], height[right]);
            // Calculate the current water area and update the max area if the new area is larger.
            max = Math.max(max, h * (right - left));
            // Move the left pointer inward if the current left height is less than or equal to h.
            while (left < right && h >= height[left]) left++;
            // Move the right pointer inward if the current right height is less than or equal to h.
            while (left < right && h >= height[right]) right--;
        }
        // Return the maximum area found.
        return max;
    }

}
