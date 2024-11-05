package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    //    https://leetcode.com/problems/longest-repeating-character-replacement/

    //      Time complexity: O(n)
//      Space complexity: O(m)
//    Where n is the length of the string and m is the total number of unique characters in the string.
    public int characterReplacement(String s, int k) {
        int left = 0;
        int result = 0;
        int maxFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(right)));

            while ((right - left + 1) - maxFrequency > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
