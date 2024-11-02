package com.leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianDataStream {
//    https://leetcode.com/problems/find-median-from-data-stream/

    //    Time Complexity:
//  addNum(int num): O(1) - Adding an element to the end of the list is constant time.
//  findMedian(): O(nlogn) - Sorting the list takes
//    Memory Complexity: O(n) - The list stores all added numbers,
// so the memory usage grows linearly with the number of elements added.
    class MedianFinder {
        // A list to store the numbers added
        List<Integer> list;

        public MedianFinder() {
            list = new ArrayList<>();
        }

        // Adds a number to the list
        public void addNum(int num) {
            list.add(num);
        }

        // Finds the median of the numbers in the list
        public double findMedian() {
            // Sorts the list every time findMedian is called
            list.sort(Integer::compare);
            int size = list.size();
            int mid = size / 2;
            // If the size is odd, return the middle element
            if (size % 2 == 1)
                return list.get(mid);
            // If the size is even, return the average of the two middle elements
            return (list.get(mid - 1) + list.get(mid)) / 2.0;
        }
    }

    //      Time Complexity:
//  addNum(int num): O(logn) - Inserting into a heap takes O(logn) time, and balancing operations are also O(logn).
//  findMedian(): O(1) - Accessing the median only involves looking at the top elements of the heaps.
//      Memory Complexity: O(n) - Both heaps combined will store all elements,
//  so the memory usage is linear in terms of the number of elements added.
    class MedianFinder2 {
        // Min-heap to store the larger half of the numbers
        PriorityQueue<Integer> minHeap;
        // Max-heap to store the smaller half of the numbers
        PriorityQueue<Integer> maxHeap;

        public MedianFinder2() {
            // Max-heap for the smaller half, so use a reverse order comparator
            minHeap = new PriorityQueue<>((a, b) -> b - a);
            // Min-heap for the larger half
            maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        }

        // Adds a number to the data structure
        public void addNum(int num) {
            // Add the number to the minHeap (the max-heap for smaller half)
            minHeap.add(num);
            // Balance: Ensure elements in minHeap are <= elements in maxHeap
            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek())
                maxHeap.offer(minHeap.poll());
            // Balance the size of the heaps so that their sizes differ by at most 1
            if (minHeap.size() > maxHeap.size() + 1)
                maxHeap.offer(minHeap.poll());
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.offer(maxHeap.poll());
        }

        // Finds the median of the numbers in the structure
        public double findMedian() {
            // If minHeap has more elements, return the top element of minHeap
            if (minHeap.size() > maxHeap.size())
                return minHeap.peek();
            // If maxHeap has more elements, return the top element of maxHeap
            if (maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            // If both heaps have the same size, return the average of the two middle elements
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

}
