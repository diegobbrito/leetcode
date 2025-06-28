package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindSubsequenceLengthKWithLargestSum {

    //https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum
    // Time Complexity: O(n log k)
    // Space Complexity: O(k)

    public int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<int[]> list = new ArrayList<>(pq);
        list.sort((a, b) -> a[1] - b[1]);

        return list.stream()
                .mapToInt(a -> a[0])
                .toArray();
    }
}
