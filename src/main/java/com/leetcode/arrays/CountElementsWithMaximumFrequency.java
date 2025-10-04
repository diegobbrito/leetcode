package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CountElementsWithMaximumFrequency {

    //    https://leetcode.com/problems/count-elements-with-maximum-frequency/
    //    Time Complexity O(n)
    //    Space Complexity O(n)

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int maxFreq = pq.peek()[1];
        int count = 0;
        while(!pq.isEmpty() && pq.peek()[1] == maxFreq) {
            count += maxFreq;
            pq.poll();
        }
        return count;
    }
}
