package com.leetcode.arrays;

import java.util.*;

public class FindResultantArrayAfterRemovingAnagrams {

    // https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
    // Time Complexity: O(n * m) where n is the number of words and m is the average length of the words
    // Space Complexity: O(n)

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String latest = "";
        for (String word : words) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!latest.equals(key)) {
                result.add(word);
                latest = key;
            }
        }
        return result;
    }
}
