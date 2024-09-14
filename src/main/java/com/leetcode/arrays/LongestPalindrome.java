package com.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {
//    https://leetcode.com/problems/longest-palindrome/

    //    Time Complexity: O(n)
//    Memory Complexity: O(n)
    public int longestPalindrome(String s) {
        // Base case: If the string has only one character, the longest palindrome is the string itself (length 1).
        if (s.length() == 1) return 1;

        // Create a map to store the frequency of each character in the string.
        Map<Character, Integer> map = new HashMap<>();

        // Loop through the string and count the occurrences of each character.
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int result = 0; // This will store the length of the longest palindrome.

        // Iterate through the string again to calculate the palindrome length.
        for (int i = 0; i < s.length(); i++) {
            // Check if the character still exists in the map.
            if (map.containsKey(s.charAt(i))) {
                int temp = map.get(s.charAt(i)); // Get the count of the character.

                // If the count is even, we can use all occurrences of this character.
                if (temp % 2 == 0) {
                    result += temp; // Add the even count to the result.
                    map.remove(s.charAt(i)); // Remove the character from the map since it's fully used.
                }
                // If the count is odd, we can use (count - 1) occurrences to maintain symmetry.
                else {
                    result += temp - 1; // Use (count - 1) occurrences.
                    map.put(s.charAt(i), 1); // Keep one occurrence for a possible central character.
                }
            }
        }

        // If the map is not empty, it means there's at least one character left for the center of the palindrome.
        return map.isEmpty() ? result : result + 1;
    }

    //    Time Complexity: O(n)
    //    Memory Complexity: O(n)
    public int longestPalindrome2(String s) {
        // Create a map to store the frequency of each character in the string.
        Map<Character, Integer> map = new HashMap<>();

        // Loop through the string and count the occurrences of each character.
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int result = 0; // This will store the length of the longest palindrome.
        boolean flag = false; // Flag to check if there is an odd count character for the center of the palindrome.

        // Iterate through the map values (the counts of each character).
        for (Integer count : map.values()) {
            // If the count is even, use all occurrences of this character.
            if (count % 2 == 0) {
                result += count;
            }
            // If the count is odd, use (count - 1) occurrences for symmetry and set the flag to true.
            else {
                result += count - 1; // Use (count - 1) occurrences.
                flag = true; // Set the flag since we can use one odd character as the center of the palindrome.
            }
        }

        // If the flag is true, we can place one odd character in the middle, so we increment the result by 1.
        return flag ? ++result : result;
    }

    //    Time Complexity: O(n)
    //    Memory Complexity: O(n)
    public int longestPalindrome3(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;

        // Loop through each character in the string.
        for (char c : s.toCharArray()) {
            // If the character is already in the set, it means we've seen it an odd number of times.
            if (set.contains(c)) {
                // We can use this pair (even occurrences), so we remove it from the set and add 2 to the result.
                set.remove(c);
                result += 2; // A pair is used.
            } else {
                // If the character is not in the set, add it to track it for future pairing.
                set.add(c);
            }
        }

        // If there are any characters left in the set, one can be used as the center of the palindrome.
        return set.isEmpty() ? result : result + 1;
    }


}
