package com.leetcode.recursion;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}

		ListNode node = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}
}

//Recursive version
class Solution {

	public ListNode reverseList(ListNode head) {
		return rev(head, null);
	}

	public ListNode rev(ListNode node, ListNode pre) {
		if (node == null) return pre;
		ListNode temp = node.next;
		node.next = pre;
		return rev(temp, node);
	}
}
class ListNode {
	int val;
 ListNode next;
 ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
