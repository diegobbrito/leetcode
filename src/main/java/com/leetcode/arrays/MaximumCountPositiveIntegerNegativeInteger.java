package com.leetcode.arrays;

public class MaximumCountPositiveIntegerNegativeInteger {

    //    https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
//    Time complexity: O(n)
//    Space complexity: O(1)
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;

        for (int num : nums) {
            if (num > 0) pos++;
            else if (num < 0) neg++;
        }
        return Math.max(pos, neg);
    }

    //    Time complexity: O(logn)
    //    Space complexity: O(1)

    public int maximumCount2(int[] nums) {

        int pos = getPos(nums);
        int neg = getNeg(nums);

        return Math.max(pos, neg);
    }

    private int getPos(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return arr.length - 1 - right;

    }

    private int getNeg(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
