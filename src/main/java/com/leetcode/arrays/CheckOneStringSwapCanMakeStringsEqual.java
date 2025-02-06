package com.leetcode.arrays;

public class CheckOneStringSwapCanMakeStringsEqual {

    //https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

    //Time complexity: O(n)
    //Space complexity: O(1)
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int[] arr = new int[26];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        if (count > 2) return false;

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    //Time complexity: O(n)
    //Space complexity: O(1)
    public boolean areAlmostEqualOptimize(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;

        int diffCount = 0;
        int[] diffIndex = new int[2]; // store the index of the different characters
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2)
                    return false;
                diffIndex[diffCount - 1] = i;
            }
        }

        return diffCount == 2 // there are only 2 different characters
                && s1.charAt(diffIndex[0]) == s2.charAt(diffIndex[1]) // the characters are swapped
                && s1.charAt(diffIndex[1]) == s2.charAt(diffIndex[0]);
    }
}
