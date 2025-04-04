package com.leetcode.slidingwindow;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    //https://leetcode.com/problems/sliding-window-maximum/
    //Time complexity: O(nlogk)
    //Space complexity: O(k)

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] response = new int[nums.length - k + 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int right = 0;
        while (right < k - 1) {
            maxHeap.offer(nums[right++]);
        }

        for (int left = 0, i = 0; right < nums.length; i++, left++, right++) {
            maxHeap.offer(nums[right]);
            response[i] = maxHeap.peek();
            maxHeap.remove(nums[left]);


        }

        return response;
    }

    //Time complexity: O(nlogk)
    //Space complexity: O(k)
    public int[] maxSlidingWindow2(int[] nums, int k) {

        int[] response = new int[nums.length - k + 1];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int right = 0;
        while (right < k - 1) {
            maxHeap.offer(new int[]{nums[right], right});
            right++;
        }

        for (int left = 0, i = 0; right < nums.length; i++, left++, right++) {
            maxHeap.offer(new int[]{nums[right], right});
            int[] max = maxHeap.peek();
            while (max[1] < left) {
                maxHeap.poll();
                max = maxHeap.peek();
            }
            response[i] = max[0];
        }

        return response;
    }
}
