package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    //    https://leetcode.com/problems/ransom-note/
    //    Total Time Complexity: O(m+n).
    //    Space Complexity: O(k)
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0)
                map.put(c, map.get(c) - 1);
        }
        for (Integer i : map.values()) {
            if (i > 0) return false;
        }
        return true;
    }

    //    Total Time Complexity: O(m+n).
    //    Space Complexity: O(k), where k is the number of unique characters in the magazine.
    public boolean canConstruct2(String ransomNote, String magazine) {
        // If the ransom note is longer than the magazine, it's impossible to construct
        // the ransom note from the magazine, so return false immediately.
        if (ransomNote.length() > magazine.length()) return false;

        // Create a HashMap to count the occurrences of each character in the magazine.
        Map<Character, Integer> map = new HashMap<>();

        // Iterate through each character in the magazine string.
        for (char c : magazine.toCharArray()) {
            // For each character, increase its count in the map.
            // If the character is not in the map, it adds the character with a count of 1.
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Iterate through each character in the ransom note string.
        for (char c : ransomNote.toCharArray()) {
            // Check if the character is not present in the map or if its count is 0,
            // which means the ransom note cannot be constructed from the magazine.
            if (!map.containsKey(c) || map.get(c) == 0) return false;

            // Decrease the count of the character in the map since it's being used.
            map.put(c, map.get(c) - 1);
        }

        // If all characters in the ransom note have been accounted for, return true.
        return true;
    }

    //    Total Time Complexity: O(m+n).
    //    Space Complexity: O(1) since the array size is fixed at 26, regardless of input size.
    public boolean canConstruct3(String ransomNote, String magazine) {
        int[] charCounts = new int[26];
        for (char c : magazine.toCharArray()) {
            charCounts[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (charCounts[c - 'a'] == 0)
                return false;
            charCounts[c - 'a']--;
        }
        return true;
    }

}
