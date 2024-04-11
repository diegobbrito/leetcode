package com.leetcode.linkedlist;
class MyLinkedList {

	MyListNode left;
	MyListNode right;

	public MyLinkedList() {
		left = new MyListNode(0);
		right = new MyListNode(0);
		left.next = right;
		right.prev = left;
	}

	public int get(int index) {
		MyListNode cur = left.next;
		while(cur != null && index > 0) {
			cur = cur.next;
			index -= 1;
		}
		if(cur != null && cur != right && index == 0) {
			return cur.val;
		}
		return -1;
	}

	public void addAtHead(int val) {
		MyListNode node = new MyListNode(val);
		MyListNode next = left.next;
		MyListNode prev = left;
		prev.next = node;
		next.prev = node;
		node.next = next;
		node.prev = prev;
	}

	public void addAtTail(int val) {
		MyListNode node = new MyListNode(val);
		MyListNode next = right;
		MyListNode prev = right.prev;
		prev.next = node;
		next.prev = node;
		node.next = next;
		node.prev = prev;
	}

	public void addAtIndex(int index, int val) {
		MyListNode cur = left.next;
		while(cur != null && index > 0) {
			cur = cur.next;
			index -= 1;
		}
		if(cur != null && index == 0) {
			MyListNode node = new MyListNode(val);
			MyListNode next = cur;
			MyListNode prev = cur.prev;
			prev.next = node;
			next.prev = node;
			node.next = next;
			node.prev = prev;
		}
	}

	public void deleteAtIndex(int index) {
		MyListNode cur = left.next;
		while(cur != null && index > 0) {
			cur = cur.next;
			index -= 1;
		}
		if(cur != null && cur != right && index == 0) {
			MyListNode next = cur.next;
			MyListNode prev = cur.prev;
			next.prev = prev;
			prev.next = next;
		}
	}
}

class MyListNode {
	int val;
	MyListNode prev;
	MyListNode next;
	public MyListNode(int val) {
		this.val = val;
		this.prev = null;
		this.next = null;
	}
}
