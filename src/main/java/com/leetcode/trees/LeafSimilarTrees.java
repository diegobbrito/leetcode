package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    //    https://leetcode.com/problems/leaf-similar-trees/
//    Time Complexity O(n + m)
//    Memory Complexity O(n + m)
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i)))
                return false;
        }

        return true;

    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorder(node.left, list);
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            inorder(node.right, list);
        }
    }
}
