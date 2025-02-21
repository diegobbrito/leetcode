package com.leetcode.trie;

public class DesignAddSearchWordsDataStructure {
    //    https://leetcode.com/problems/design-add-and-search-words-data-structure/

    // Time Complexity: O(N) where N is the length of the word
    // Space Complexity: O(N) where N is the length of the word


    private TrieNode root;

    public DesignAddSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode cur = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return cur.word;
    }

    class TrieNode {

        TrieNode[] children;
        boolean word;

        public TrieNode() {
            children = new TrieNode[26];
            word = false;
        }
    }
}
