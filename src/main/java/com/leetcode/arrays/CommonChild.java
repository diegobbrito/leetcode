package com.leetcode.arrays;

public class CommonChild {

//    https://www.hackerrank.com/challenges/common-child/problem

    //Time complexity: O(n^2)
    //Space complexity: O(n^2)

    public static int commonChild(String s1, String s2) {
        int n = s1.length(); //s1 and s2 have the same length
        int[][] dp = new int[n + 1][n + 1]; //dp[i][j] is the length of the longest common subsequence of s1[0..i-1] and s2[0..j-1]

        for (int i = 1; i <= n; i++) { //i is the length of s1
            char c1 = s1.charAt(i - 1); //c1 is the i-th character of s1
            for (int j = 1; j <= n; j++) { //j is the length of s2
                char c2 = s2.charAt(j - 1); //c2 is the j-th character of s2
                if (c1 == c2) { //if the i-th character of s1 is the same as the j-th character of s2
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //if the i-th character of s1 is not the same as the j-th character of s2
                }
            }
        }

        return dp[n][n];//return the length of the longest common subsequence of s1 and s2
    }
}
