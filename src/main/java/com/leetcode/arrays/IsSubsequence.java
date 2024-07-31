package com.leetcode.arrays;

public class IsSubsequence {
//    https://leetcode.com/problems/is-subsequence/

    //    Time Complexity O(n)
//    Memory Complexity O(1)
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen > tLen) return false;
        int sIndex = 0, tIndex = 0;
        while (sIndex < sLen && tIndex < tLen) {
            if (s.charAt(sIndex) == t.charAt(tIndex))
                sIndex++;
            tIndex++;
        }
        return sIndex == sLen;
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(1)
    public boolean isSubsequence2(String s, String t) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index);
            if (index < 0) return false;
            index++;
        }
        return true;
    }
}


