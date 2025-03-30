package com.leetcode.stack;

public class ClearDigits {

    //https://leetcode.com/problems/clear-digits

    //Time complexity: O(n)
    //Space complexity: O(n)

    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                sb.append(c);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }
}
