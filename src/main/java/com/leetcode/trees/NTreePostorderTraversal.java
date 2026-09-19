package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class NTreePostorderTraversal {

//    https://neetcode.io/problems/n-ary-tree-postorder-traversal/question
//    Time Complexity O(n)
//    Space Complexity O(n)

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);
        return list;
    }

    private void dfs(Node root, List<Integer> list){
        if(root == null) return;
        for(Node node : root.children){
            dfs(node, list);
        }
        list.add(root.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
