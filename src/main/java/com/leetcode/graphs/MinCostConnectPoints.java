package com.leetcode.graphs;

import java.util.Arrays;

public class MinCostConnectPoints {

    //    https://leetcode.com/problems/min-cost-to-connect-all-points/
    // Time complexity: O(n^2)
    // Space complexity: O(n)

    public int minCostConnectPoints(int[][] points) {
        int length = points.length, node = 0;
        int[] dist = new int[length];
        boolean[] visit = new boolean[length];
        Arrays.fill(dist, 100000000);
        int edges = 0, result = 0;

        while (edges < length - 1) {
            visit[node] = true;
            int nextNode = -1;
            for (int i = 0; i < length; i++) {
                if (visit[i]) continue;
                int curDist = Math.abs(points[i][0] - points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                dist[i] = Math.min(dist[i], curDist);
                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }
            result += dist[nextNode];
            node = nextNode;
            edges++;
        }
        return result;
    }
}
