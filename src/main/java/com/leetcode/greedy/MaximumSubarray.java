package com.leetcode.greedy;

public class MaximumSubarray {
    //    https://leetcode.com/problems/maximum-subarray/
//    Time Complexity O(n)
//    Memory Complexity O(1)
    public int maxSubArray(int[] nums) {
        // Initialize maxCount to the first element of the array.
        // This is because the maximum sum subarray has to include at least one element.
        int maxCount = nums[0];

        // Initialize currentCount to 0. This will track the sum of the current subarray.
        int currentCount = 0;

        // Iterate over each element in the array.
        for (int num : nums) {
            // If currentCount is negative, we discard it and start from 0.
            // Then, we add the current element (num) to currentCount.
            currentCount = Math.max(currentCount, 0) + num;

            // Update maxCount to the maximum value between maxCount and currentCount.
            // This keeps track of the largest subarray sum found so far.
            maxCount = Math.max(currentCount, maxCount);
        }

        // Return the maximum subarray sum found.
        return maxCount;
    }

    //    Time Complexity O(n)
//    Memory Complexity O(1)
    public int maxSubArray2(int[] nums) {
        int maxSub = nums[0];
        int total = 0;
        for (int num : nums) {
            if (total < 0) total = 0;
            total += num;
            maxSub = Math.max(maxSub, total);
        }
        return maxSub;
    }

}
