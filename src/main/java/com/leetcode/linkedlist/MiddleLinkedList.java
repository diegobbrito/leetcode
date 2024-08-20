package com.leetcode.linkedlist;

public class MiddleLinkedList {
//    https://leetcode.com/problems/middle-of-the-linked-list/submissions/1360295847/

    //    Method 1: Two-Pass Approach
//      Time Complexity: O(n), where n is the number of nodes in the list.
//      The list is traversed twice: once to count the nodes and again to find the middle node.
//      Space Complexity: O(1), since the method uses only a few extra variables regardless of the input size.
    public ListNode middleNode(ListNode head) {
        int count = 0;
        var curr = head;
        // First pass: count the total number of nodes in the list
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        // Calculate the index of the middle node
        int mid = count / 2;
        count = 0;
        // Second pass: traverse the list again to reach the middle node
        while (head != null && count != mid) {
            count++;
            head = head.next;
        }
        // Return the middle node
        return head;
    }

    //    Method 2: One-Pass (Tortoise and Hare) Approach
//      Time Complexity: O(n), where n is the number of nodes in the list.
//      The list is traversed once with the two pointers.
//      Space Complexity: O(1), since the method only uses a constant amount of extra space for the two pointers.
    public ListNode middleNode2(ListNode head) {
        var slow = head;
        var fast = head;

        // Traverse the list with two pointers: 'slow' and 'fast'
        while (fast != null && fast.next != null) {
            // 'fast' moves two steps at a time
            fast = fast.next.next;
            // 'slow' moves one step at a time
            slow = slow.next;
        }

        // When 'fast' reaches the end, 'slow' will be at the middle node
        return slow;
    }

}
