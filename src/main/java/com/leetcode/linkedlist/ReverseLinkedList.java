package com.leetcode.linkedlist;

import java.util.ArrayList;

public class ReverseLinkedList {

//	https://leetcode.com/problems/reverse-linked-list/description/
public ListNode reverseList(ListNode head) {
	// Time complexity: O(n), where n is the number of nodes in the linked list.
	// We traverse the list once to fill the ArrayList and then loop again to build the reversed list.

	// Space complexity: O(n) due to the use of an ArrayList that stores all nodes.
	if (head == null)
		return head;

	ArrayList<ListNode> list = new ArrayList<>();
	while (head != null) {
		list.add(head);
		head = head.next;
	}

	// Create a new list starting with the last node of the original list.
	var response = new ListNode(list.get(list.size() - 1).val);
	var cur = response;

	// Loop through the ArrayList from the second-last to the first node.
	for (int i = list.size() - 2; i >= 0; i--) {
		cur.next = new ListNode(list.get(i).val);
		cur = cur.next;
	}

	return response;
}

	public ListNode reverseListIterative(ListNode head) {
		// Time complexity: O(n), where n is the number of nodes in the linked list.
		// We traverse the list exactly once.

		// Space complexity: O(1), as we are only using a few pointers (newHead, next).
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next; // Store the next node.
			head.next = newHead; // Reverse the pointer.
			newHead = head; // Move the newHead to the current node.
			head = next; // Move to the next node.
		}
		return newHead;
	}

	public ListNode reverseListRecursive(ListNode head) {
		// Time complexity: O(n), where n is the number of nodes in the linked list.
		// Each node is visited once during the recursive call.

		// Space complexity: O(n) due to the recursion stack. Each recursive call adds to the stack,
		// and there are n calls in total (one for each node).
		if (head == null || head.next == null) return head;

		ListNode newHead = reverseListRecursive(head.next); // Reverse the rest of the list.
		head.next.next = head; // Reverse the current node's pointer.
		head.next = null; // Break the original link to avoid cycles.

		return newHead;
	}


}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



