package com.leetcode.arrays;

public class MaximumScoreAfterSplittingString {

//    https://leetcode.com/problems/maximum-score-after-splitting-a-string/
//    Time Complexity - O(n)
//    Space Complexity - O(n)
    public int maxScore(String s) {
        int[] preFix = new int[s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                count++;
            preFix[i] = count;
        }
        int result = 0;
        count = 0;
        for (int left = 0; left < s.length(); left++) {
            if (s.charAt(left) == '0')
                count++;
            result = Math.max(result, count + preFix[left]);
        }
        return result;
    }

//    Iteration (One Pass)
//    Time Complexity - O(n)
//    Space Complexity - O(1)

    public int maxScoreOptimize(String s) {
        int zeros = 0, ones = 0, result = -1;
        if (s.charAt(0) == '0') zeros++;
        else ones++;

        for (int i = 1; i < s.length(); i++) {
            result = Math.max(result, zeros - ones);
            if (s.charAt(i) == '1') ones++;
            else zeros++;
        }
        return result + ones;
    }

//    Iteration (Two Pass)
//    Time Complexity - O(n)
//    Space Complexity - O(1)

    public int maxScoreIteration(String s) {
        int zeros = 0, ones = 0, result = -1;

        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') zeros++;
            else ones--;
            result = Math.max(result, zeros + ones);
        }

        return result;
    }
}
