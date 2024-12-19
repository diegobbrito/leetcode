package com.leetcode.sorting;

public class MedianTwoSortedArrays {
//    Binary Search
//    Time complexity:O(log(min(n,m)))
//    Space complexity:O(1)

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure the first array is the smaller one to minimize the binary search range
        if (nums1.length > nums2.length)
            return helper(nums2, nums1);
        return helper(nums1, nums2);
    }

    // Helper method to perform binary search to find the median
    private double helper(int[] arrA, int[] arrB) {
        int total = arrA.length + arrB.length; // Total length of both arrays
        int half = (total + 1) / 2; // Halfway point
        int left = 0, right = arrA.length; // Binary search range

        while (left <= right) {
            int i = (left + right) / 2; // Midpoint of arrA
            int j = half - i; // Corresponding point in arrB

            // Edge cases for array bounds
            int leftA = i > 0 ? arrA[i - 1] : Integer.MIN_VALUE;
            int rightA = i < arrA.length ? arrA[i] : Integer.MAX_VALUE;
            int leftB = j > 0 ? arrB[j - 1] : Integer.MIN_VALUE;
            int rightB = j < arrB.length ? arrB[j] : Integer.MAX_VALUE;

            // Check if we have found the correct partition
            if (leftA <= rightB && leftB <= rightA)
                // If total length is odd, return the max of left parts
                // If even, return the average of the max of left parts and min of right parts
                return total % 2 != 0 ?
                        Math.max(leftA, leftB) : (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
            else if (leftA > rightB)
                right = i - 1; // Move search range left
            else
                left = i + 1; // Move search range right
        }
        return -1; // Should never reach here
    }

//  Brute Force
//    Time complexity:O(n+m)
//    Space complexity:O(n+m)

    // This method finds the median of two sorted arrays using brute force
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arr = new int[n1 + n2]; // Merged array
        int i = 0, j = 0, index = 0;

        // Merge the two arrays
        while (i < n1 && j < n2)
            if (nums1[i] < nums2[j])
                arr[index++] = nums1[i++];
            else
                arr[index++] = nums2[j++];
        while (i < n1) arr[index++] = nums1[i++];
        while (j < n2) arr[index++] = nums2[j++];

        int mid = arr.length / 2;
        // If the merged array length is odd, return the middle element
        // If even, return the average of the two middle elements
        if (arr.length % 2 != 0)
            return arr[mid];
        return (arr[mid] + arr[mid - 1]) / 2.0;
    }
}
