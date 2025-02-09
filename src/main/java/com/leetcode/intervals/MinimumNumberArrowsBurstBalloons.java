package com.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrowsBurstBalloons {

//    https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

    //Time complexity: O(nlogn)
    //Space complexity: O(1)
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // sort the balloons by the end
        int count = 1;
        int end = points[0][1]; // store the end of the first balloon
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) { // if the start of the current balloon is greater than the end of the previous balloon
                count++; // we need to shoot another arrow
                end = points[i][1]; // update the end of the balloon
            }
        }
        return count;
    }

}
