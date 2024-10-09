package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
//    https://leetcode.com/problems/merge-intervals/

    //    Time Complexity:
    //Sorting the intervals: The sorting operation dominates the time complexity, which is O(n log n) where n is the number of intervals.
    //Merging intervals: The merging process involves a single pass through the sorted intervals, which takes O(n) time.
    //Overall time complexity: O(n log n)
    //Space Complexity:
    //Auxiliary list aux: The space required to store the merged intervals is O(n) in the worst case, where no intervals overlap.
    //Result array: Another O(n) space is used to store the final result.
    //Overall space complexity: O(n)
    public int[][] merge(int[][] intervals) {
        // Get the number of intervals (rows)
        int rows = intervals.length;

        // Sort the intervals by their starting values using a comparator
        // Time complexity: O(n log n) due to sorting, where n is the number of intervals
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Create a list to store merged intervals
        List<int[]> aux = new ArrayList<>();

        // Add the first interval to the list, as the starting point
        aux.add(intervals[0]);

        // Loop through the remaining intervals
        for (int i = 1, lastIndex = 0; i < rows; i++) {
            // Extract the start and end of the current interval
            int start = intervals[i][0], end = intervals[i][1];
            // Get the end of the last interval in the aux list
            int lastEnd = aux.get(lastIndex)[1];
            // Check if the current interval overlaps with the last interval
            if (start <= lastEnd)
                // If they overlap, merge by updating the end of the last interval
                aux.get(lastIndex)[1] = Math.max(lastEnd, end);
            else {
                // If no overlap, add the current interval to the list
                aux.add(new int[]{start, end});
                lastIndex++;
            }

        }
        // Convert the list of merged intervals back into a 2D array
        int[][] result = new int[aux.size()][2];
        aux.toArray(result);
        // Return the merged intervals
        return result;
    }


    public int[][] mergeWithoutArraySort(int[][] intervals) {
        int rows = intervals.length;

        // Sort the intervals by their starting values using custom merge sort
        mergeSort(intervals, 0, rows - 1);

        // Create a list to store merged intervals
        List<int[]> aux = new ArrayList<>();

        // Add the first interval to the list
        aux.add(intervals[0]);

        // Loop through the sorted intervals and merge them
        for (int i = 1; i < rows; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            int lastIndex = aux.size() - 1, lastEnd = aux.get(lastIndex)[1];

            // If the intervals overlap, merge them
            if (start <= lastEnd) {
                aux.get(lastIndex)[1] = Math.max(lastEnd, end);
            } else {
                aux.add(new int[]{start, end});
            }
        }

        // Convert the list of merged intervals back into a 2D array
        int[][] result = new int[aux.size()][2];
        aux.toArray(result);

        return result;
    }

    // Custom merge sort function
    private void mergeSort(int[][] intervals, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively divide the array
            mergeSort(intervals, left, mid);
            mergeSort(intervals, mid + 1, right);

            // Merge the two halves
            merge(intervals, left, mid, right);
        }
    }

    // Helper function to merge two sorted halves
    private void merge(int[][] intervals, int left, int mid, int right) {
        // Calculate the size of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays for both halves
        int[][] leftArr = new int[n1][2];
        int[][] rightArr = new int[n2][2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = intervals[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = intervals[mid + 1 + i];
        }

        // Merge the temp arrays back into the original array
        int i = 0, j = 0, k = left;

        // Compare the starting values and merge them back
        while (i < n1 && j < n2) {
            if (leftArr[i][0] <= rightArr[j][0]) {
                intervals[k++] = leftArr[i++];
            } else {
                intervals[k++] = rightArr[j++];
            }
        }

        // Copy the remaining elements, if any
        while (i < n1) {
            intervals[k++] = leftArr[i++];
        }
        while (j < n2) {
            intervals[k++] = rightArr[j++];
        }
    }


}
