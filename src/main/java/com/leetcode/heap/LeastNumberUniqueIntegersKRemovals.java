package com.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberUniqueIntegersKRemovals {
//    https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (var i : map.entrySet()) {
            pq.add(new Pair<>(i.getKey(), i.getValue()));
        }
        for (int i = 0; i < k; i++) {
            var pair = pq.poll();
            if (pair.value > 1) {
                pq.add(new Pair<>(pair.key, pair.value - 1));
            }
        }
        return pq.size();
    }

    static class Pair<K, V> implements Comparable<Pair<K, V>> {
        K key;
        V value;

        // Constructor to initialize the pair with key and value
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair<K, V> o) {
            if ((int) this.value > (int) o.value)
                return 1;
            else if (this.value == o.value)
                return 0;
            return -1;
        }
    }
}
