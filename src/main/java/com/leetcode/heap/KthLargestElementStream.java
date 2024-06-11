package com.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargestElementStream {
}
class KthLargest {
//https://leetcode.com/problems/kth-largest-element-in-a-stream/
/*
// For this solution, its use the Priority Queue
// Since the problem only want the Kth greater element, we only add this amount of number in the queue
//	That make the algorithm fast
*/
	PriorityQueue<Integer> heap;
	int element;

	public KthLargest(int k, int[] nums) {
		heap = new PriorityQueue<>();
		this.element = k;
		for (int num : nums) {
			add(num);
		}
	}

	public int add(int val) {

		heap.offer(val);// Add the values of the array
		if(heap.size() > element) // Check if the size of heap is greater than the element searched
			heap.poll(); //	Remove the value
		return heap.peek(); //return the minimum value
	}
}
