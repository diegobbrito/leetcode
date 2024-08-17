package com.leetcode.linkedlist;

public class RemoveLinkedListElements {
//    https://leetcode.com/problems/remove-linked-list-elements/

    //    Time Complexity: O(n), where n is the number of nodes in the list.
//    The method iterates through the list once, checking each node.
//    Space Complexity: O(1), as no extra space proportional to the input size is used; only a few pointers are maintained.
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node that points to the head of the list
        // This helps in handling edge cases where the head node itself needs to be removed
        var dummy = new ListNode(0, head);
        // Initialize two pointers: 'curr' to traverse the list, and 'prev' to keep track of the node before 'curr'
        ListNode curr = head, prev = dummy;
        while (curr != null) {
            var next = curr.next;
            // If the current node's value matches 'val', remove the current node by linking 'prev' to 'next'
            if (curr.val == val) prev.next = next;
                // Otherwise, move 'prev' forward to 'curr'
            else prev = curr;
            // Move 'curr' to the next node
            curr = next;
        }
        // Return the head of the modified list (dummy.next)
        return dummy.next;
    }


//    Time Complexity: O(n), where n is the number of nodes in the list.
//    Each node is visited once.

    //    Space Complexity: O(n), due to the recursion stack.
//    In the worst case, the stack depth could be equal to the number of nodes in the list.
    public ListNode removeElements2(ListNode head, int val) {
        // Base case: if the list is empty, return null
        if (head == null)
            return null;
        // Recursively call the method on the next node
        head.next = removeElements2(head.next, val);
        // If the current node's value matches 'val', skip this node by returning 'head.next'
        if (head.val == val)
            return head.next;
        // Otherwise, keep the current node by returning 'head'
        return head;
    }
}
