package com.leetcode.heap;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
//    https://leetcode.com/problems/furthest-building-you-can-reach/

    public static void main(String[] args) {
        furthestBuilding(new int[]{1, 5, 1, 2, 3, 4, 10000}, 4, 1);
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) continue;
            pq.add(heights[i + 1] - heights[i]);
        }

        int largest = 0;
        if (!pq.isEmpty()) largest = pq.poll();
        int i = 0;
        for (; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) continue;
            int diff = heights[i + 1] - heights[i];
            if (ladders > 0 && diff == largest) {
                ladders--;
                if (ladders > 0 && !pq.isEmpty())
                    largest = pq.poll();
            } else if (bricks >= diff) {
                bricks -= diff;
            } else if (ladders > 0) {
                ladders--;
            } else {
                break;
            }
        }

        return i;
    }
}
