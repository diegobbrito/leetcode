package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    //    https://leetcode.com/problems/insert-interval/
//Time Complexity: O(n), where n is the number of intervals in the input array.
// Each interval is processed exactly once, and adding to the result list is O(1) per operation.
//Space Complexity: O(n), where n is the number of intervals.
// The space complexity is due to the result list, which holds all the intervals (either the original or merged intervals).
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length; // Get the number of existing intervals
        List<int[]> result = new ArrayList<>(); // List to store the merged intervals

        // Loop through all the intervals
        for (int[] interval : intervals) {
            // Case 1: The current interval ends before the new interval starts (no overlap)
            // Add the current interval to the result as is
            if (newInterval == null || interval[1] < newInterval[0]) {
                result.add(interval);

                // Case 2: The current interval starts after the new interval ends (no overlap)
                // Add the new interval to the result and then the current interval
                // Set newInterval to null since it's been added
            } else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;

                // Case 3: Overlapping intervals
                // Merge the current interval with the newInterval by updating its start and end
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]); // Choose the earlier start time
                newInterval[1] = Math.max(interval[1], newInterval[1]); // Choose the later end time
            }
        }

        // If the newInterval hasn't been added, add it to the result
        if (newInterval != null) {
            result.add(newInterval);
        }

        // Convert the list of merged intervals back to a 2D array and return it
        return result.toArray(new int[result.size()][]);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals that end before the new interval starts (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]); // Update the start
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]); // Update the end
            i++;
        }
        // Add the merged interval
        result.add(newInterval);

        // Step 3: Add all intervals that start after the new interval ends (no overlap)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the list of merged intervals back to a 2D array and return it
        return result.toArray(new int[result.size()][]);
    }


}
