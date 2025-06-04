package com.leetcode.twopointers;

public class FindLexicographicallyLargestStringFromBoxI {

    // https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String s = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (res.compareTo(s) <= 0) {
                res = s;
            }
        }
        return res;
    }

}
