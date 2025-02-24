package com.leetcode.linkedlist;

public class SwapNodesPairs {

    //Time Complexity O(n)
    //Space Complexity O(1)
    public ListNode swapPairs(ListNode head) {

        var dummy = new ListNode(0, head); //dummy node
        var cur = dummy; //current node

        while (cur.next != null && cur.next.next != null) { //check if there are two nodes to swap
            var prev = cur.next; //first node
            var next = cur.next.next; //second node

            prev.next = next.next; //first node next pointer points to second nodes next pointer
            next.next = prev; //second node next pointer points to prev node

            cur.next = next; //current node next pointer points to second node
            cur = prev; //current node points to first node
        }

        return dummy.next;
    }
}
