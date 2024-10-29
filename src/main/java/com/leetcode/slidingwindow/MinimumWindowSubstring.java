package com.leetcode.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
//    https://leetcode.com/problems/minimum-window-substring/

    /**
     * Time Complexity: O(N)
     * - N is the length of string `s`.
     * - The `right` pointer traverses `s` once, and the `left` pointer also moves at most N times, making it linear.
     * <p>
     * Space Complexity: O(M)
     * - M is the number of unique characters in string `t`.
     * - The `countT` map stores up to M entries, where M <= N.
     */
    public String minWindow(String s, String t) {
        // Map to store character counts of the target string `t`
        HashMap<Character, Integer> countT = new HashMap<>();
        // Initialize count map with characters in `t`
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int matched = 0;      // Number of characters in `t` matched in the current window
        int left = 0;         // Left pointer for the sliding window
        int startIndex = 0;    // Starting index of the minimum window substring
        int minLen = s.length() + 1; // Initialize min length larger than any possible window
        // Expand the right pointer of the window
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right); // Current character at the right pointer
            // If the character is in `t`, decrement its count in the map
            if (countT.containsKey(r)) {
                countT.put(r, countT.get(r) - 1);
                // Increment matched count if we have enough of this character in the window
                if (countT.get(r) == 0) matched++;
            }
            // Shrink the window from the left if all characters in `t` are matched
            while (matched == countT.size()) {
                // Update minimum length and starting index of the substring if necessary
                if (minLen > (right - left + 1)) {
                    minLen = right - left + 1;
                    startIndex = left;
                }
                // Remove the character at the left pointer from the window
                char deleted = s.charAt(left++);
                if (countT.containsKey(deleted)) {
                    // If this character was fully matched, decrement matched count
                    if (countT.get(deleted) == 0) matched--;
                    countT.put(deleted, countT.get(deleted) + 1); // Update its count in the map
                }
            }
        }
        // Return the smallest window substring or an empty string if no valid window found
        return minLen > s.length() ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
