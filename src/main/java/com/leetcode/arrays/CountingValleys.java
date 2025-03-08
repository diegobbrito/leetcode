package com.leetcode.arrays;

public class CountingValleys {
//    https://www.hackerrank.com/challenges/counting-valleys

    // Time: O(n), Space: O(1)
    public static int countingValleys(int steps, String path) {
        int result = 0, seaLevel = 0;
        boolean valley = false;
        for (char c : path.toCharArray()) {
            seaLevel += c == 'D' ? -1 : 1;
            if (seaLevel == 0 && valley) {
                result++;
                valley = false;
            }
            if (seaLevel < 0)
                valley = true;
        }
        return result;
    }
}
