package com.leetcode.graphs;

import java.util.*;

public class AccountsMerge {
//    https://leetcode.com/problems/accounts-merge/

    /**
     * Merges email accounts based on common emails.
     * Time Complexity: O(N * α(N) + M log M)
     * where N is the number of accounts, α(N) is the inverse Ackermann function (near constant for practical use),
     * and M is the total number of emails.
     * Space Complexity: O(N + M)
     * where N is the number of accounts and M is the total number of emails.
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        DSU dsu = new DSU(size); // Initialize DSU for merging accounts

        // Map to store email -> account index
        Map<String, Integer> map = new HashMap<>();

        // Step 1: Group accounts based on shared emails
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {  // j starts from 1 to skip the name
                var email = accounts.get(i).get(j);
                // If the email is not seen before, map it to the current account index
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    // Union current account with the account that already has this email
                    dsu.union(i, map.get(email));
                }
            }
        }

        // Step 2: Merge accounts based on DSU groups
        Map<Integer, List<String>> merged = new HashMap<>();

        for (String email : map.keySet()) {
            int group = map.get(email);
            int lead = dsu.find(group); // Find the leader of the group
            merged.putIfAbsent(lead, new ArrayList<>()); // Create list if not present
            merged.get(lead).add(email); // Add email to the group's list
        }

        // Step 3: Sort and prepare the result
        List<List<String>> result = new ArrayList<>();
        for (int ac : merged.keySet()) {
            List<String> group = merged.get(ac);
            Collections.sort(group); // Sort emails alphabetically
            group.add(0, accounts.get(ac).get(0)); // Add the account holder's name at the beginning
            result.add(group); // Add this group to the final result
        }

        return result; // Return the merged account lists
    }

    /**
     * Disjoint Set Union (DSU) or Union-Find data structure.
     * Time Complexity: O(α(N)) per find or union operation, where α is the inverse Ackermann function.
     * Space Complexity: O(N) where N is the number of accounts.
     */
    class DSU {
        int[] parent;
        int[] rank;

        // Constructor to initialize the DSU with the size of accounts
        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // Initially, each element is its own parent
            }
        }

        // Find with path compression to optimize future searches
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Recursively find the root parent
            }
            return parent[x];
        }

        // Union by rank to keep the tree flat
        public boolean union(int x, int y) {
            int xr = find(x);
            int yr = find(y);
            if (xr == yr) return false; // Already in the same group

            // Union by rank: attach the shorter tree under the taller tree
            if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else {
                parent[xr] = yr;
                rank[xr]++;
            }
            return true;
        }
    }

}
