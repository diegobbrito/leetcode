package com.leetcode.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackQueues {
//	https://leetcode.com/problems/implement-stack-using-queues/
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.top(); // return 2
		myStack.pop(); // return 2
		myStack.empty(); // return False
	}
}

class MyStack {

	Queue<Integer> queue;

	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.add(x);
	}

	public int pop() {

		int size = queue.size();
		for(int i = 0; i < size - 1; i++)
			this.push(queue.poll());
		return queue.poll();
	}

	public int top() {
		int size = queue.size();
		for(int i = 0; i < size - 1; i++)
			this.push(queue.poll());

		int res = queue.peek();
		this.push(queue.poll());
		return res;
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}
