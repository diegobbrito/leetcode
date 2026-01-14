package com.leetcode.searching;

public class ScoreString {

//    https://leetcode.com/problems/score-of-a-string/
//    Time Complexity O(n)
//    Space Complexity O(1)

    public int scoreOfString(String s) {
        int result = 0;
        for(int l = 0, r = 1; r < s.length(); l++, r++){
            result += Math.abs(s.charAt(l) - s.charAt(r));
        }
        return result;
    }
}
