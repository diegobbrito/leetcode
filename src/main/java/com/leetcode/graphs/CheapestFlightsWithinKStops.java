package com.leetcode.graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {

    //    https://leetcode.com/problems/cheapest-flights-within-k-stops/
    //Time complexity: O(n * k)
    //Space complexity: O(n + m)

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (var flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});

        while (!q.isEmpty()) {
            var curr = q.poll();
            int cst = curr[0], node = curr[1], stops = curr[2];
            if (stops > k) continue;

            for (var neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCost = cst + w;
                if (nextCost < prices[nei]) {
                    prices[nei] = nextCost;
                    q.offer(new int[]{nextCost, nei, stops + 1});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
