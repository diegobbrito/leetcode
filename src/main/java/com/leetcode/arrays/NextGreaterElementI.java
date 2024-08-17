package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    //    https://leetcode.com/problems/next-greater-element-i/
    public static void main(String[] args) {
        nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

//      Method 1: Brute-Force Approach
//      Time Complexity: O(m * n), where m is the length of nums1 and n is the length of nums2.
//      For each element in nums1, the method may traverse most or all of nums2.

    //      Space Complexity: O(1), excluding the output array, since no extra space proportional to the input size is used.
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length];

        // Iterate over each element in nums1
        for (int i = 0; i < length; i++) {
            int j = 0;
            var num = nums1[i];

            // Find the index of nums1[i] in nums2
            while (num != nums2[j]) j++;

            // Search for the next greater element in nums2
            while (j <= length2) {
                if (j == length2) break;  // Reached end of nums2 without finding a greater element
                if (num < nums2[j]) break; // Found the next greater element
                j++;
            }

            // Assign the result for the current element in nums1
            result[i] = j < length2 ? nums2[j] : -1; // If j < length2, nums2[j] is the next greater element; otherwise, -1
        }

        return result;
    }

//      Method 2: Optimized Approach Using a Stack and HashMap
//      Time Complexity: O(m + n), where m is the length of nums1 and n is the length of nums2.
//      The method processes each element in nums2 once,
//      and then it retrieves results for each element in nums1 from the map in constant time.

    //    Space Complexity: O(n), where n is the length of nums2.
//    This is due to the space required for the stack and the map used to store the next greater elements.
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        var stack = new Stack<Integer>();
        var map = new HashMap<Integer, Integer>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            var current = nums2[i];
            // Maintain the stack such that the top is always the next greater element
            while (!stack.isEmpty() && stack.peek() <= current)
                stack.pop();
            // If stack is empty, there's no greater element; otherwise, the top is the next greater element
            var nextGreaterElement = stack.isEmpty() ? -1 : stack.peek();
            // Map the current number to its next greater element
            map.put(current, nextGreaterElement);
            // Push the current number onto the stack
            stack.push(current);
        }
        // Build the result array for nums1 based on the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++)
            result[i] = map.get(nums1[i]);

        return result;
    }

}
