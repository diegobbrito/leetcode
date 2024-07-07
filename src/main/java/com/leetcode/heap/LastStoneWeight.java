package com.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 2}));
    }

    //    Time complexity: O(n∗logn)
//    Space complexity: O(n)
    public static int lastStoneWeight(int[] stones) {
        // Created a max heap, using reverse order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // getting the biggest value
            int x = maxHeap.poll(); // getting the second-biggest value
            if (x != y)// check if they are not equal and adding to the heap the new value
                maxHeap.offer(y - x);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek(); // add the check if the heap is empty and returning 0
    }
}
