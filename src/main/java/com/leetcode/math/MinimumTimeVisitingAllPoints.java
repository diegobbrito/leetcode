package com.leetcode.math;

public class MinimumTimeVisitingAllPoints {

//    https://leetcode.com/problems/minimum-time-visiting-all-points/
//    Time Complexity O(n)
//    Space Complexity O(1)

    public int minTimeToVisitAllPoints(int[][] points) {
        int left = points[0][0];
        int right = points[0][1];
        int result = 0;
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            result += Math.max(Math.abs(left - x), Math.abs(right - y));
            left = x;
            right = y;
        }

        return result;
    }
}
