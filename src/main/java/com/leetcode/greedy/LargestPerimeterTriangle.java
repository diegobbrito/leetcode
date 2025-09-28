package com.leetcode.greedy;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    // https://leetcode.com/problems/largest-perimeter-triangle/
    // Time complexity: O(n log n)
    // Space complexity: O(1)

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
