package com.leetcode.sorting;

import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI {

//    https://neetcode.io/problems/final-array-state-after-k-multiplication-operations-i/
//    Time Complexity: O((k + n) * log n)
//    Space Complexity: O(n)

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int comp = Integer.compare(a[0], b[0]);
            return (comp != 0) ? comp : Integer.compare(a[1], b[1]);
        });
        for(int i = 0; i < nums.length; i++){
            pq.offer(new int[]{nums[i], i});
        }
        while(k > 0){
            int index = pq.poll()[1];
            nums[index] *= multiplier;
            pq.offer(new int[]{nums[index], index});
            k--;
        }
        return nums;
    }
}
