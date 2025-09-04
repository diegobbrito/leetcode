package com.leetcode.math;

public class FindClosestPerson {

    // https://leetcode.com/problems/find-closest-person/
    // Time complexity: O(1)
    // Space complexity: O(1)
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(z - x);
        int b = Math.abs(z - y);
        if(a == b) return 0;
        return a < b ? 1 : 2;
    }
}
