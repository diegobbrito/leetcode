package com.leetcode.graphs;

import java.util.*;

public class ReconstructFlightPath {

    // https://leetcode.com/problems/reconstruct-itinerary/
    // Time complexity: O(n log n)
    // Space complexity: O(n)
    //Where N is the number of tickets (edges)
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        List<String> res = new ArrayList<>();
        dfs(adj, "JFK", res);

        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj,
                     String src, List<String> res) {
        PriorityQueue<String> queue = adj.get(src);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adj, dst, res);
        }
        res.add(src);
    }
}
