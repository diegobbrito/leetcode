package com.leetcode.linkedlist;

public class MyLinkedList {

	MyLinkedList head;
	MyLinkedList tail;
	int val;
	MyLinkedList next;
	MyLinkedList prev;

	MyLinkedList(){
	}


	public int get(int index) {
		var cur = this.head;
		for (int i = 0; i <= index; i++) {
			if(cur == null)
				return -1;
			if(i == index)
				return cur.val;
			cur = cur.next;
		}
		return -1;
	}

	public void addAtHead(int val) {
		var newHead = new MyLinkedList();
		newHead.val = val;
		if(head == null){
			head = newHead;
			tail = newHead;
		}
		else{
			newHead.next = this.head;
			this.head.prev = newHead;
			head = newHead;
		}
	}

	public void addAtTail(int val) {
		var newTail = new MyLinkedList();
		newTail.val = val;
		if(tail == null){
			head = newTail;
		}else{
			newTail.prev = tail;
			this.tail.next = newTail;
		}
		tail = newTail;
	}

	public void addAtIndex(int index, int val) {
		var newNode = new MyLinkedList();
		newNode.val = val;
		if (head == null){
			head = newNode;
			tail = newNode;
			return;
		}
		if (index == 0){
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		else {
			var cur = this.head;
			for (int i = 0; i <= index; i++) {
				if( cur != null && cur.next == null && i + 1 == index){
					addAtTail(val);
					i++;
					break;
				}
				else if(i == index && cur != null){
					newNode.prev = cur.prev;
					newNode.next = cur;
					newNode.prev.next = newNode;
					newNode.next.prev = newNode;
					break;
				}
				cur = cur.next;
			}
		}
	}

	public void deleteAtIndex(int index) {
		var cur = this.head;
		for (int i = 0; i <= index; i++) {
			if(0 == index){
				this.head = head.next;
				return;
			}else if(i == index && cur != null){
				if(cur.next != null)
					cur.next.prev = cur.prev;
				if (cur.prev != null)
					cur.prev.next = cur.next;
				break;
			}
			if(cur != null)
				cur = cur.next;
		}
	}

	public static void main(String[] args) {
		var test = new MyLinkedList();

		test.addAtIndex(0, 10);
		test.addAtIndex(0, 20);
		test.addAtIndex(1, 30);

		System.out.println(test.get(0));

	}
}
