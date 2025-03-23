package com.leetcode.heap;

import java.util.List;
import java.util.PriorityQueue;

public class LuckBalance {

//    https://www.hackerrank.com/challenges/luck-balance/problem
    //Time complexity: O(nlogn)
    //Space complexity: O(n)

    public static int luckBalance(int k, List<List<Integer>> contests) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int sum = 0;
        for (List<Integer> contest : contests) {
            int l = contest.get(0);
            int t = contest.get(1);
            if (t == 0) {
                sum += l;
            } else {
                maxHeap.add(l);
            }
        }

        while (k > 0 && !maxHeap.isEmpty()) {
            sum += maxHeap.poll();
            k--;
        }

        while (!maxHeap.isEmpty()) {
            sum -= maxHeap.poll();
        }

        return sum;
    }
}
