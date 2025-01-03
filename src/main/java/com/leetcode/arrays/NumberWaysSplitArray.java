package com.leetcode.arrays;

public class NumberWaysSplitArray {

//https://leetcode.com/problems/number-of-ways-to-split-array/

    //    Time complexity: O(n)
//    Space complexity: O(n)
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] preFix = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            preFix[i] = sum;
        }

        long[] posFix = new long[n];
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            posFix[i] = sum;
        }
        int splits = 0;
        for (int i = 0; i < n - 1; i++) {
            if (preFix[i] >= posFix[i + 1]) splits++;
        }
        return splits;
    }

    //    Time complexity: O(n)
//    Space complexity: O(n)
    public int waysToSplitArray2(int[] nums) {
        int n = nums.length;
        long[] preFix = new long[n]; //prefix sum, use long to avoid overflow
        long sum = 0; // sum of all elements, use long to avoid overflow
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            preFix[i] = sum;
        }
        int splits = 0;
        for (int i = 0; i < n - 1; i++) {
            if (preFix[i] >= sum - preFix[i]) //check if the first part is greater than the sum of the rest of the array
                splits++;
        }
        return splits;
    }
}
