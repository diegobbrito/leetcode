package com.leetcode.arrays;

public class MaximumOddBinaryNumber {
//    https://leetcode.com/problems/maximum-odd-binary-number/

    //Time complexity: O(n)
    //Space complexity: O(n)

    public String maximumOddBinaryNumber(String s) {
        int ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        StringBuilder sb = new StringBuilder();
        int zeros = s.length() - ones;
        while (ones > 1) {
            sb.append("1");
            ones--;
        }

        sb.append("0".repeat(Math.max(0, s.length() - (s.length() - zeros))));
        sb.append("1");

        return sb.toString();
    }
}
