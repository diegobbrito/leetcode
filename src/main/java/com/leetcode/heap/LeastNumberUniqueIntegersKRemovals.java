package com.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberUniqueIntegersKRemovals {
//    https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
//Time Complexity
//Building the frequency map: O(N).
//Adding frequencies to the heap: O(MlogM), where M≤N is the number of unique integers.
//Removing k elements: O(klogM).
//Overall Time Complexity: O(N+MlogM+klogM).
//In the worst case, M=N, so this simplifies to O(NlogN).

    //    Space Complexity
//Frequency map: O(M), where M is the number of unique integers.
//PriorityQueue: O(M).
//Overall Space Complexity: O(M).
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        pq.addAll(map.values());

        for (int i = 0; i < k; i++) {
            var value = pq.poll();
            if (value != null && value > 1)
                pq.add(value - 1);
        }
        return pq.size();
    }
}
