package com.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsString {
//    https://leetcode.com/problems/find-all-anagrams-in-a-string/

    //Approach 1: Brute Force with Substrings
//    Time Complexity:
//The outer loop runs O(n - m), where n is the length of s and m is the length of p.
//For each substring comparison, the isAnagram function takes O(m) time to create the frequency map.
//Hence, the overall time complexity is O((n - m) * m).
//    Space Complexity:
//The space complexity is O(m) for storing the frequency map for each substring comparison.
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pSize = p.length();
        // Iterate over each substring of length equal to 'p' in 's'
        for (int i = 0; i < s.length() - pSize; i++) {
            // Check if the substring is an anagram of 'p'
            if (isAnagram(s.substring(i, i + pSize), p)) {
                result.add(i);  // If yes, add the start index to the result list
            }
        }
        return result;
    }

    private boolean isAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        // Build a frequency map for both strings 'a' and 'b'
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1); // Increment count for characters in 'a'
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) - 1); // Decrement count for characters in 'b'
        }
        // Check if all values in the frequency map are zero
        for (Integer i : map.values())
            if (i != 0) return false;  // If any value is not zero, 'a' and 'b' are not anagrams
        return true;
    }

    //Approach 2: Sliding Window with HashMap
//      Time Complexity:
//The sliding window takes O(n), where n is the length of s,
// since each character is added and removed from the map only once.
//Comparison of the two hashmaps is O(1) due to a fixed number of unique characters (at most 26 for lowercase letters).
//Hence, the overall time complexity is O(n).
//      Space Complexity:
//The space complexity is O(1), as the size of the frequency map is limited to a constant size (26 lowercase letters).
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();
        // Build frequency maps for the first window of 's' and the pattern 'p'
        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        int left = 0;
        if (sCount.equals(pCount)) result.add(left);  // If the initial window is an anagram, add the index
        // Slide the window across 's'
        for (int right = p.length(); right < s.length(); right++) {
            sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0) + 1);  // Add new character to window
            sCount.put(s.charAt(left), sCount.getOrDefault(s.charAt(left), 0) - 1);    // Remove leftmost character from window
            if (sCount.get(s.charAt(left)) == 0) sCount.remove(s.charAt(left));         // Remove zero-count entries
            left++;  // Move the window
            if (sCount.equals(pCount)) result.add(left);  // If current window is an anagram, add the index
        }
        return result;
    }

}
