package com.leetcode.slidingwindow;

import java.util.Arrays;

public class FrequencyTheMostFrequentElement {

    //https://leetcode.com/problems/frequency-of-the-most-frequent-element/
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(1)

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long total = 0;
        int res = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            while ((long) nums[r] * (r - l + 1) > total + k) {
                total -= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
