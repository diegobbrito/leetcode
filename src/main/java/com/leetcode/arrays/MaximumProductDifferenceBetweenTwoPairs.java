package com.leetcode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumProductDifferenceBetweenTwoPairs {

    //    https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
//    Time Complexity O(nlogn)
//    Space Complexity O(n)
//    Priority Queue
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

    //    Time Complexity O(nlogn)
//    Space Complexity O(n)
//    Sorting
    public int maxProductDifferenceSorting(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }

    //    Time Complexity O(n)
//    Space Complexity O(1)
//    Two Maximums and Two Minimums
    public int maxProductDifferenceOptimize(int[] nums) {
        int max1 = 0, max2 = 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return (max1 * max2) - (min1 * min2);
    }
}
