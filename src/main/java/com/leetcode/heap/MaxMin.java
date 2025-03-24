package com.leetcode.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxMin {

    //https://www.hackerrank.com/challenges/angry-children/problem

    //Time complexity: O(nlogn)
    //Space complexity: O(n)
    public static int maxMin(int k, List<Integer> arr) {
        arr.sort(Comparator.comparingInt(a -> a));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr.get(i));
            minHeap.offer(arr.get(i));
        }
        int max = maxHeap.peek();
        int min = minHeap.peek();
        int minUnfairness = max - min;
        for (int i = k; i < arr.size(); i++) {
            maxHeap.remove(arr.get(i - k));
            minHeap.remove(arr.get(i - k));
            maxHeap.offer(arr.get(i));
            minHeap.offer(arr.get(i));
            max = maxHeap.peek();
            min = minHeap.peek();
            minUnfairness = Math.min(minUnfairness, max - min);
        }

        return minUnfairness;
    }


    //Time complexity: O(nlogn)
    //Space complexity: O(1)
    public static int maxMin2(int k, List<Integer> arr) {
        arr.sort(Comparator.comparingInt(a -> a));
        int minUnfairness = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - k; i++) {
            minUnfairness = Math.min(minUnfairness, arr.get(i + k - 1) - arr.get(i));
        }
        return minUnfairness;
    }
}
