package com.leetcode.linkedlist;

import java.util.ArrayList;

public class ReverseLinkedList {

//	https://leetcode.com/problems/reverse-linked-list/description/
	public ListNode reverseList(ListNode head) {

		if(head == null)
			return head;
		ArrayList<ListNode> list = new ArrayList<>();

		while (head != null){
			list.add(head);
			head = head.next;
		}

		var response = new ListNode(list.get(list.size()-1).val);

		var cur = response;

		for (int i = list.size() - 2; i >=0 ; i--) {
			cur.next = new ListNode(list.get(i).val);
			cur = cur.next;
		}

		return response;
	}
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

//		 /* iterative solution */
//
//	 public ListNode reverseList(ListNode head) {
//		 ListNode newHead = null;
//		 while (head != null) {
//			 ListNode next = head.next;
//			 head.next = newHead;
//			 newHead = head;
//			 head = next;
//		 }
//		 return newHead;
//	 }
//
//		 /* recursive solution */
//
//	 public ListNode reverseList(ListNode head) {
//		 if(head == null || head.next == null) return head;
//		 ListNode newHead = reverseList(head.next);
//		 head.next.next = head;
//		 head.next = null;
//		 return newHead;
//	 }

