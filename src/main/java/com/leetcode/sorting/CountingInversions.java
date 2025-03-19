package com.leetcode.sorting;

import java.util.List;

public class CountingInversions {

//    https://www.hackerrank.com/challenges/ctci-merge-sort/problem
//    Time complexity: O(n²), Space complexity: O(1)

    public static long countInversions(List<Integer> arr) {
        // Write your code here
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            int a = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                if (a > arr.get(j)) count++;
            }
        }
        return count;
    }


    //    Time complexity: O(nlogn), Space complexity: O(n)

    public static long countInversions2(List<Integer> arr) {
        long[] count = new long[1];

        int[] merge = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            merge[i] = arr.get(i);
        }

        mergeSort(merge, count);

        return count[0];
    }

    private static void mergeSort(int[] arr, long[] count) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left, count);
        mergeSort(right, count);
        merge(arr, left, right, count);
    }

    private static void merge(int[] arr, int[] left, int[] right, long[] count) {
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                arr[i++] = left[l++];
            } else {
                arr[i++] = right[r++];
                count[0] += left.length - l; //count inversions
            }
        }
        while (l < left.length) {
            arr[i++] = left[l++];
        }
        while (r < right.length) {
            arr[i++] = right[r++];
        }
    }
}
