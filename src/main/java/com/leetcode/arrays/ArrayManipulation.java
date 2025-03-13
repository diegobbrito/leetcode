package com.leetcode.arrays;

import java.util.List;

public class ArrayManipulation {


    //    Time complexity: O(n * m), Space complexity: O(n)
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        int[] arr = new int[n + 1];
        int max = 0;
        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);
            for (int j = a; j <= b; j++) {
                arr[j] += k;
                max = Math.max(max, arr[j]);
            }
        }
        return max;
    }

    //    Time complexity: O(n + m), Space complexity: O(n)
    public static long arrayManipulationOptimized(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 1];
        long max = 0;
        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);
            arr[a] += k; // Add k to the start of the range
            if (b + 1 <= n) { // Subtract k from the end of the range + 1
                arr[b + 1] -= k;
            }
        }
        long sum = 0; // Calculate the prefix sum
        for (int i = 1; i <= n; i++) { // Find the maximum value
            sum += arr[i]; // Add the current value to the sum
            max = Math.max(max, sum); // Update the maximum value
        }
        return max;
    }
}
