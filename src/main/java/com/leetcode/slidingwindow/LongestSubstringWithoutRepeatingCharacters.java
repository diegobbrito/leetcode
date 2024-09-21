package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
//    https://leetcode.com/problems/longest-substring-without-repeating-characters/

    //    Time Complexity: O(n^2)
//    In the worst case, we are resetting the map and rechecking the string, making this solution quadratic.
//    Space Complexity: O(n)
//    The HashMap stores the characters in the worst case up to n, where n is the length of the string.
    public int lengthOfLongestSubstring(String s) {
        // Map to store characters and their most recent index in the string
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;  // Tracks the length of the longest substring without repeating characters
        int count = 0; // Current count of non-repeating characters

        // Iterate over each character in the string
        for (int i = 0; i < s.length(); i++) {
            // If the character is already in the map, it means there's a repetition
            if (map.containsKey(s.charAt(i))) {
                // Update max to the largest between the current max and the count
                max = Math.max(max, count);
                // Reset the count since we found a repetition
                count = 0;
                // Move the index to the last occurrence of the repeated character
                i = map.get(s.charAt(i));
                // Reset the map for the next possible substring
                map = new HashMap<>();
            } else {
                // If no repetition, add the character and its index to the map
                map.put(s.charAt(i), i);
                count++; // Increment the current substring count
            }
        }

        // Check once more at the end in case the longest substring is at the end of the string
        max = Math.max(max, count);
        return max;
    }

    /*
    Time Complexity: O(n)
    Each character is processed at most twice, once by the right pointer and once by the left pointer.
    Space Complexity: O(n)
    The HashSet stores the characters in the current window, which can be at most n in size.
    */
    public int lengthOfLongestSubstring2(String s) {
        // A set to track characters in the current window of non-repeating characters
        Set<Character> set = new HashSet<>();

        int left = 0;  // Left pointer of the sliding window
        int max = 0;   // Tracks the maximum length of non-repeating substring

        // Iterate over the string with the right pointer, which expands the window
        for (int right = 0, size = s.length(); right < size; right++) {
            // If the character at the right pointer is already in the set (i.e., it's a repetition)
            while (set.contains(s.charAt(right))) {
                // Remove the character at the left pointer and move the left pointer forward
                set.remove(s.charAt(left++));
            }
            // Add the current character at the right pointer to the set
            set.add(s.charAt(right));
            // Update max to the largest between the current max and the size of the window (right - left + 1)
            max = Math.max(max, right - left + 1);
        }

        return max;
    }


}
