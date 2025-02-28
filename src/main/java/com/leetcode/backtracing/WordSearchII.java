package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    //https://leetcode.com/problems/word-break-ii/
    // Time: O(m + n * 2^n), Space: O(m+2^n)
    List<String> result;
    Set<String> set;

    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        set = new HashSet<>(wordDict);
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int i, List<String> cur) {
        if (i == s.length()) {
            result.add(String.join(" ", cur));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            var word = s.substring(i, j + 1);
            if (set.contains(word)) {
                cur.add(word);
                backtrack(s, j + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
