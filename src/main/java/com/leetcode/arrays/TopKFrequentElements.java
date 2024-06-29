package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    //    https://leetcode.com/problems/top-k-frequent-elements/description/
    public int[] topKFrequent(int[] nums, int k) {
        // Create a result with the size o k elements needed
        int[] result = new int[k];
        // Add a map to count the occurrences for each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Create a priority queue comparing the values and using the if statement to let the queue with the size of elements required
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // Adding the element to the response
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}
