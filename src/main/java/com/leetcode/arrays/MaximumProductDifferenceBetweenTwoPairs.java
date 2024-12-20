package com.leetcode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumProductDifferenceBetweenTwoPairs {

    //    https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
//    Time Complexity O(nlogn)
//    Space Complexity O(n)
    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            min.add(num);
            max.add(num);
        }

        int a = min.poll();
        int b = min.poll();
        int c = max.poll();
        int d = max.poll();

        return (c * d) - (a * b);
    }

    public int maxProductDifferenceSorting(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }
}
