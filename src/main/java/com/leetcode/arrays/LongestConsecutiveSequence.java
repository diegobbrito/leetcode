package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    //    https://leetcode.com/problems/longest-consecutive-sequence/
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
    }

    // Time complexity O(n)
    // Memory complexity O(n) - because the extra Set
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); //Create a set to have only unique numbers of the array
        for (int num : nums)
            set.add(num);

        int longest = 0;// Started the longest variable at 0, if array is empty

        for (int num : nums) {
            // Validate for every number in the array if it has a left number in the set
            // If it doesn't, the number is the initial number of a sequence
            if (!set.contains(num - 1)) {
                // Start the size of the sequence at 1
                int length = 1;

                // Check with the while loop if the set contains the next number in the sequence num + length
                while (set.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);// Validate if the current sequence if the longest found in the array
            }
        }
        return longest;
    }

}
