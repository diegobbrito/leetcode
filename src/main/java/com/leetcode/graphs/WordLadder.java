package com.leetcode.graphs;

import java.util.*;

public class WordLadder {
    //    https://leetcode.com/problems/word-ladder/
//      Complexity Analysis
//  Time Complexity: O(N×M²)
//  N is the number of words in wordList. M is the length of each word.
//  Building the adjacency list takes O(N×M²) because for each word,
//  we generate M patterns and each pattern manipulation takes O(M).
//  BFS traversal also takes O(N×M²) since for each word we explore up to M patterns and each pattern lookup takes O(M).
//  Space Complexity: O(N×M²)
//  The adjacency list adjList holds N×M patterns, with each pattern linked to words, which can be up to O(N×M) total words.
//  The visited set and queue also take up to O(N) space.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create an adjacency list to map word patterns to words.
        // E.g., "h*t" -> ["hot", "hat"]
        Map<String, List<String>> adjList = new HashMap<>();
        // Add the beginWord to wordList to ensure it's included in the graph.
        wordList.add(beginWord);
        // Build the adjacency list by generating patterns for each word
        // in the wordList. For each position in the word, replace that
        // position with '*' to create a pattern, e.g., "hot" -> "h*t", "*ot", "ho*".
        for (String word : wordList) {
            StringBuilder sb;
            for (int i = 0; i < word.length(); i++) {
                sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                List<String> wordlist = adjList.getOrDefault(sb.toString(), new ArrayList<>());
                wordlist.add(word);
                adjList.put(sb.toString(), wordlist);
            }
        }
        // Initialize a queue for BFS, starting from the beginWord.
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;  // The initial step count.
        // Perform BFS to find the shortest path.
        while (!queue.isEmpty()) {
            step++;  // Increment step count with each level of BFS.
            int size = queue.size();
            // Iterate over all words in the current BFS level.
            for (int j = 0; j < size; j++) {
                String word = queue.poll();
                // For each character position in the word, create pattern.
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, '*');
                    // Retrieve the words corresponding to this pattern.
                    for (String pat : adjList.get(sb.toString())) {
                        // If endWord is found, return the current step count.
                        if (pat.equals(endWord))
                            return step;
                        // Skip already visited words.
                        if (visited.contains(pat))
                            continue;
                        // Add the word to the queue for the next BFS level.
                        queue.offer(pat);
                        visited.add(pat);
                    }
                }
            }
        }
        // Return 0 if no transformation sequence was found.
        return 0;
    }

}
