package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer {

    //https://leetcode.com/problems/copy-list-with-random-pointer/

    // Time complexity: O(n)
    // Space complexity: O(n)
    public Node copyRandomList(Node head) {
        var cur = head;
        var dummy = new Node(0);
        var newHead = dummy;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            var temp = new Node(cur.val);
            newHead.next = temp;
            map.put(cur, temp);
            cur = cur.next;
            newHead = newHead.next;
        }
        newHead = dummy.next;
        while (head != null) {
            if (head.random != null) {
                newHead.random = map.get(head.random);
            }
            newHead = newHead.next;
            head = head.next;
        }
        return dummy.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
