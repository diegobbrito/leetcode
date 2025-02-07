package com.leetcode.linkedlist;

public class ReverseNodeskGroup {

//    https://leetcode.com/problems/reverse-nodes-in-k-group/

    // Time complexity: O(n), where n is the number of nodes in the linked list.
    // We traverse the list exactly once.
    // Space complexity: O(1), as we are only using a few pointers (dummy, groupPrev, kth, groupNext, prev, curr, tmp).
    public ListNode reverseKGroup(ListNode head, int k) {
        var dummy = new ListNode(0, head);
        var groupPrev = dummy; // store the previous node of the group

        while (true) { // loop until we can reverse k nodes
            var kth = getKth(groupPrev, k); // get the kth node
            if (kth == null) break;
            var groupNext = kth.next; // store the next node of the kth node
            var prev = kth.next;
            var curr = groupPrev.next; // start from the first node of the group
            while (curr != groupNext) { // reverse the group
                var tmp = curr.next; // store the next node
                curr.next = prev; // reverse the pointer
                prev = curr; // move the prev to the current node
                curr = tmp; // move the current node to the next node
            }
            var tmp = groupPrev.next; // store the first node of the group
            groupPrev.next = kth; // move the groupPrev to the kth node
            groupPrev = tmp; // move the groupPrev to the first node of the group
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
