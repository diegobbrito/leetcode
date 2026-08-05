package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

//    https://neetcode.io/problems/populating-next-right-pointers-in-each-node/
//    Time Complexity O(n)
//    Space Complexity O(n)

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            Node last = null;
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                curr.next = last;
                last = curr;
                if(curr.right != null){
                    queue.offer(curr.right);
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
            }
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
