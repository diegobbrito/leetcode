package com.leetcode.arrays;

public class MaximumDifferenceBetweenEvenOddFrequencyI {

    //    https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i
//    Time Complexity: O(n)
//    Space Complexity: O(1)
    public int maxDifference(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (count[i] == 0)
                continue;

            if (count[i] % 2 == 0) {
                minEven = Math.min(minEven, count[i]);
            } else {
                maxOdd = Math.max(maxOdd, count[i]);
            }
        }

        return maxOdd - minEven;
    }
}
