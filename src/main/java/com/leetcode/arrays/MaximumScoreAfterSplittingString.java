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
}
