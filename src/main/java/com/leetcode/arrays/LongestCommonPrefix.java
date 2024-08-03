package com.leetcode.arrays;

public class LongestCommonPrefix {
    //    https://leetcode.com/problems/longest-common-prefix/
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            prefix.append(strs[0].charAt(i));
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix.toString())) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix.toString();
    }

    //    Time Complexity O(nm)
//    Memory Complexity O(1)
    public String longestCommonPrefix2(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            prefix.append(strs[0].charAt(i));
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix.toString();
    }
}
