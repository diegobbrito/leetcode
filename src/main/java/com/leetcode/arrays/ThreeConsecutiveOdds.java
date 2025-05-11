package com.leetcode.arrays;

public class ThreeConsecutiveOdds {

    //https://leetcode.com/problems/three-consecutive-odds
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
