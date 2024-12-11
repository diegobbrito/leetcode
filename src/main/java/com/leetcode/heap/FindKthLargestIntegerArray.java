package com.leetcode.heap;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargestIntegerArray {
//    https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigDecimal> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (String num : nums) {
            pq.add(new BigDecimal(num));
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        return String.valueOf(pq.poll());
    }
}
