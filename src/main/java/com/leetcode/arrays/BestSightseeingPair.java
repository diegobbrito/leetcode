package com.leetcode.arrays;

public class BestSightseeingPair {
    //    https://leetcode.com/problems/best-sightseeing-pair/
//    Brute force
//    Time complexity: O(n^2)
//    Space complexity: O(1)
    public int maxScoreSightseeingPair(int[] values) {
        int size = values.length;
        int max = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int sum = values[i] + values[j] + i - j;
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    //    Dynamic Programming
//    Time complexity: O(n)
//    Space complexity: O(1)
    public int maxScoreSightseeingPair2(int[] values) {
        int maxScore = 0;
        int maxValue = values[0];  // Initialize with the first value + its index 0
        for (int j = 1, size = values.length; j < size; j++) {
            // Calculate the score using the best 'i' encountered so far
            maxScore = Math.max(maxScore, maxValue + values[j] - j);
            // Update the best 'i' value for future comparisons (values[i] + i)
            maxValue = Math.max(maxValue, values[j] + j);
        }
        return maxScore;
    }
}
