package com.leetcode.linkedlist;

public class RemoveNthNodeFromEndList {
    //    https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//    1,2,3,4,5
    public static void main(String[] args) {
        var head = new ListNode(1);
        head.next = new ListNode(2);

        removeNthFromEnd(head, 2);
    }

    //    Time complexity O(n)
//    Memory complexity O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        var curr = head;
        // Check the size of the list
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        if (count == n) return head.next; // if the list is the size of n, return the second element
        curr = head;
        // Get the first element before the element to be removed
        for (int i = 0; i < count - n - 1; i++) {
            curr = curr.next;
        }
        // Remove the element by changing the pointer to the next element
        curr.next = curr.next.next;
        return head;
    }

    //    Time complexity O(n)
    //    Memory complexity O(1)
    //    Two Pointers solution
    public static ListNode removeNthFromEndTwoPointers(ListNode head, int n) {
        var dummy = new ListNode(0, head); // Create a dummy node to help the removal of the element
        var slow = dummy;
        var fast = head;
        // Get the fast pointer to the difference between the end of list and the Nth element to be removed
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // Move the fast and slow element until the fast in at the end of the list
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Slow pointer will be at the element before the element to be removed
        // Remove the element by changing the pointer to the next element
        slow.next = slow.next.next;

        return dummy.next;
    }

}
