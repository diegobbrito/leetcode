package com.leetcode.greedy;

public class MergeTripletsFormTarget {

    // https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
    // Time complexity: O(n)
    // Space complexity: O(1)
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false, y = false, z = false;
        for (int[] t : triplets) {
            x |= (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2]);
            y |= (t[0] <= target[0] && t[1] == target[1] && t[2] <= target[2]);
            z |= (t[0] <= target[0] && t[1] <= target[1] && t[2] == target[2]);
            if (x && y && z) {
                return true;
            }
        }
        return false;
    }
}
