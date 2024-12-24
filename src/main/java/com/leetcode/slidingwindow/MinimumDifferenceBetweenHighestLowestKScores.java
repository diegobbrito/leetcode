package com.leetcode.slidingwindow;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestLowestKScores {
    //    https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
//    Time Complexity - O(nlogn)
//    Space Complexity - O(1)
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int left = 0, right = k - 1, size = nums.length - k + 1; left < size; left++, right++) {
            if (nums[right] - nums[left] < min) {
                min = nums[right] - nums[left];
            }
        }
        return min;
    }
}
