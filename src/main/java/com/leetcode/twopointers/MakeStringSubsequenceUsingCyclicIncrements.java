package com.leetcode.twopointers;

public class MakeStringSubsequenceUsingCyclicIncrements {
    //    https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
//    Time Complexity O(n), where n is the length of str1
//    Memory Complexity O(1)
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, sLen1 = str1.length();
        int j = 0, sLen2 = str2.length();

        while (i < sLen1 && j < sLen2) {
            if (isValid(str1.charAt(i), str2.charAt(j)))
                j++;
            i++;
        }
        return j == sLen2;
    }

    private boolean isValid(char a, char b) {
        if (a == b) return true;
        if (a == 'z') a = 'a';
        else a++;
        return a == b;
    }
}
