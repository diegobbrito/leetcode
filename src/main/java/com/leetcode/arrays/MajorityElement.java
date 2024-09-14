package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    //    https://leetcode.com/problems/majority-element/

    // Time Complexity O(2.n) = O(n), since we traverse the array twice (once to build the map and once to find the majority element).
    // Memory Complexity O(n), as we use a HashMap to store the frequency of each element.
    public int majorityElement(int[] nums) {
        // Create a HashMap to store the frequency of each element in the array.
        Map<Integer, Integer> map = new HashMap<>();

        // First loop: Count the occurrences of each element in the array.
        for (Integer i : nums) {
            // Use getOrDefault to update the frequency of each element.
            // If the element is not in the map, its default value will be 0.
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int majority = 0; // Variable to store the majority element.
        int max = 0; // Variable to store the maximum frequency.

        // Second loop: Iterate through the map's keys to find the element with the highest frequency.
        for (Integer i : map.keySet()) {
            // If the frequency of the current element is greater than 'max', update 'majority' and 'max'.
            if (map.get(i) > max) {
                max = map.get(i);
                majority = i;
            }
        }

        // Return the element that appears most frequently in the array.
        return majority;
    }

    // Time Complexity O(n), since we traverse the array once.
    // Memory Complexity O(1), since we only use a few extra variables (constant space).
    public int majorityElement2(int[] nums) {
        int majority = 0; // Variable to store the current candidate for the majority element.
        int count = 0; // Counter to track how many times the current candidate has been seen.

        // Boyer-Moore Voting Algorithm: We try to find the majority element by canceling out pairs of elements.
        for (int num : nums) {
            // If count is 0, we select the current element as the new candidate.
            if (count == 0)
                majority = num;

            // If the current element is the same as the candidate, increment count, otherwise decrement it.
            count += (num == majority) ? 1 : -1;
        }

        // After traversing the array, 'majority' will contain the majority element.
        return majority;
    }
}
