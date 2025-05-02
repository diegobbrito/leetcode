package com.leetcode.graphs;

import java.util.*;

public class AlienDictionary {

    // https://leetcode.com/problems/alien-dictionary/
    // Time complexity: O(N + E), where N is the number of characters and E is the number of edges.
    // Space complexity: O(N + E)

    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() &&
                    w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j),
                                indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            char char_ = q.poll();
            res.append(char_);
            for (char neighbor : adj.get(char_)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (res.length() != indegree.size()) {
            return "";
        }

        return res.toString();
    }
}
