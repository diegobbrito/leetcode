package com.leetcode.arrays;

public class ZeroArrayTransformationII {

//    https://leetcode.com/problems/zero-array-transformation-ii/


    // Time Complexity O(nlogn)
    // Space Complexity O(n)
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length;

        // Zero array isn't formed after all queries are processed
        if (!currentIndexZero(nums, queries, right)) {
            return -1;
        }

        // Binary Search
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (currentIndexZero(nums, queries, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Return earliest query that zero array can be formed
        return left;
    }

    private boolean currentIndexZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] differenceArray = new int[n + 1];

        // Process queries
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {
            int left = queries[queryIndex][0];
            int right = queries[queryIndex][1];
            int val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            if (right + 1 < n) {
                differenceArray[right + 1] -= val;
            }
        }

        // Check if zero array can be formed
        int sum = 0;
        for (int numIndex = 0; numIndex < n; numIndex++) {
            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) {
                return false;
            }
        }
        return true;
    }

}
