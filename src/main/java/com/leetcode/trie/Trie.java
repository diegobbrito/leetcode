package com.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
//    https://leetcode.com/problems/implement-trie-prefix-tree/

    // Root node of the Trie, initialized with an empty TrieNode
    TrieNode root;

    // Constructor initializes the Trie with a root node
    public Trie() {
        this.root = new TrieNode();
    }

    // Time complexity: O(n), where n is the length of the word.
    // Space complexity: O(n) in the worst case, when inserting a completely new word
    // that has no shared prefix with other words in the Trie.

    // Insert a word into the Trie
    public void insert(String word) {
        var curr = root; // Start at the root
        // Iterate through each character of the word
        for (char c : word.toCharArray()) {
            // If the current character is not present as a child, add it
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            // Move to the child node corresponding to the current character
            curr = curr.children.get(c);
        }
        // Mark the end of the word
        curr.word = true;
    }


    // Time complexity: O(n), where n is the length of the word.
    // Space complexity: O(1), no extra space is used except for pointers.

    // Search for a word in the Trie
    public boolean search(String word) {
        var curr = root; // Start at the root
        // Iterate through each character of the word
        for (char c : word.toCharArray()) {
            // If the character is not found in the children map, return false
            if (!curr.children.containsKey(c)) {
                return false;
            }
            // Move to the child node corresponding to the current character
            curr = curr.children.get(c);
        }
        // Return true if the word exists (marked by the word flag), otherwise false
        return curr.word;
    }

    // Time complexity: O(n), where n is the length of the prefix.
    // Space complexity: O(1), no extra space is used except for pointers.

    // Check if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        var curr = root; // Start at the root
        // Iterate through each character of the prefix
        for (char c : prefix.toCharArray()) {
            // If the character is not found in the children map, return false
            if (!curr.children.containsKey(c)) {
                return false;
            }
            // Move to the child node corresponding to the current character
            curr = curr.children.get(c);
        }
        // If all characters of the prefix are found, return true
        return true;
    }

}

// The TrieNode class represents each node in the Trie structure
class TrieNode {
    // HashMap to store children nodes corresponding to each character
    Map<Character, TrieNode> children = new HashMap<>();

    // Boolean to mark if the node represents the end of a word
    boolean word = false;
}
