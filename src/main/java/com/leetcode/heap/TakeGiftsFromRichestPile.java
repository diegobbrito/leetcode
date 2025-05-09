package com.leetcode.heap;

import java.util.PriorityQueue;

public class TakeGiftsFromRichestPile {

    // https://leetcode.com/problems/take-gifts-from-the-richest-pile/
    // Time complexity: O(k * log n)
    // Space complexity: O(n)

    public long pickGifts(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));    // MAX-HEAP

        for (int num : nums) {
            pq.add(num);
        }

        long sum = 0;
        while (k-- > 0) {
            pq.add((int) Math.sqrt(pq.remove()));
        }

        while (!pq.isEmpty()) {
            sum += pq.remove();
        }

        return sum;
    }
}
