package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeBST {
    //https://leetcode.com/problems/serialize-and-deserialize-bst/

    // Time complexity: O(n)
    // Space complexity: O(n)

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();

        dfsSerialize(root, list);

        return String.join(",", list);
    }

    private void dfsSerialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfsSerialize(root.left, list);
        dfsSerialize(root.right, list);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = new int[1];
        return dfsDeserialize(values, index);
    }

    private TreeNode dfsDeserialize(String[] values, int[] index) {
        if ("N".equals(values[index[0]])) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        root.left = dfsDeserialize(values, index);
        root.right = dfsDeserialize(values, index);
        return root;
    }
}
