package com.leetcode.arrays;

import java.util.List;

public class JumpingOnClouds {
//    https://www.hackerrank.com/challenges/jumping-on-the-clouds

    // Time: O(2^n), Space: O(n)
    public static int jumpingOnClouds(List<Integer> c) {
        return canGetToTheFinal(c, 0, 0);
    }

    private static int canGetToTheFinal(List<Integer> c, int start, int count) {
        if (start >= c.size() - 1) return count;
        if (c.get(start) == 1) return Integer.MAX_VALUE;
        int one = canGetToTheFinal(c, start + 1, count + 1);
        int two = canGetToTheFinal(c, start + 2, count + 1);

        return Math.min(one, two);
    }

    // Time: O(n), Space: O(1)
    public static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i++;
            }
            jumps++;
        }
        return jumps;
    }


}
