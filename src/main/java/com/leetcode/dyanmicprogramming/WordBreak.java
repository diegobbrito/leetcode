package com.leetcode.dyanmicprogramming;

import java.util.*;

public class WordBreak {
    //    https://leetcode.com/problems/word-break/
//    Time complexity is O(n * m * w)
//    n is the length of the string s,
//    m is the number of words in wordDict,
//    w is the maximum length of a word in wordDict.
//    Space complexity is O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        // Create a boolean array to store if a substring starting at index i can be segmented.
        // dp[i] is true if the substring s[i...] can be segmented into words from wordDict.
        boolean[] dp = new boolean[s.length() + 1];
        // The base case: an empty substring (after the end of the string) can always be segmented.
        dp[s.length()] = true;
        // Store the length of the input string for easier access
        int wordSize = s.length();
        // Iterate over the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            // Check all words in the dictionary
            for (String word : wordDict) {
                // Get the length of the current word in the dictionary
                int currWordSize = word.length();
                // Check if the word fits starting from index i and if the substring matches the word
                if ((i + currWordSize) <= wordSize && s.substring(i, i + currWordSize).equals(word)) {
                    // If a match is found, check if the remaining part can be segmented (dp[i + currWordSize])
                    dp[i] = dp[i + currWordSize];
                }
                // If dp[i] becomes true, no need to check further words
                if (dp[i]) break;
            }
        }
        // The result is whether the whole string can be segmented, which is stored in dp[0]
        return dp[0];
    }

    //    Recursive DFS with Memoization Solution
    public boolean wordBreak2(String s, List<String> wordDict) {
        // Convert the wordDict list to a set for faster lookups
        Set<String> wordSet = new HashSet<>(wordDict);

        // Create a memoization map where key is the starting index and value is whether the substring can be segmented
        Map<Integer, Boolean> memo = new HashMap<>();

        // Call the helper function starting from index 0
        return dfs(s, 0, wordSet, memo);
    }

    private boolean dfs(String s, int start, Set<String> wordSet, Map<Integer, Boolean> memo) {
        // If we have already processed this index, return the stored result
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        // If we've reached the end of the string, return true (base case)
        if (start == s.length()) {
            return true;
        }

        // Try every possible end index for the current substring
        for (int end = start + 1; end <= s.length(); end++) {
            // If the current substring (from start to end) is in the word set
            if (wordSet.contains(s.substring(start, end))) {
                // Recursively check if the rest of the string can be segmented
                if (dfs(s, end, wordSet, memo)) {
                    // If true, memoize the result and return true
                    memo.put(start, true);
                    return true;
                }
            }
        }

        // If no valid segmentation is found, memoize the result as false
        memo.put(start, false);
        return false;
    }

    //    Bottom-Up Dynamic Programming Solution:
    public boolean wordBreak3(String s, List<String> wordDict) {
        // Convert the wordDict list into a HashSet for faster lookups
        Set<String> wordSet = new HashSet<>(wordDict);

        // DP array where dp[i] is true if the substring s[0:i] can be segmented
        boolean[] dp = new boolean[s.length() + 1];

        // Base case: empty string can be segmented
        dp[0] = true;

        // Fill the dp array iteratively
        for (int i = 1; i <= s.length(); i++) {
            // Check every possible substring that ends at index i
            for (int j = 0; j < i; j++) {
                // If s[0:j] can be segmented (dp[j] is true) and s[j:i] is in the wordSet
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we've found a valid segmentation
                }
            }
        }

        // Return whether the entire string can be segmented (dp[s.length()])
        return dp[s.length()];
    }


}
