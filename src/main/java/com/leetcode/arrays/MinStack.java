package com.leetcode.arrays;

import java.util.Stack;

class MinStack {

//	https://leetcode.com/problems/min-stack/

	// 'stack' is used to store the actual values pushed into the MinStack.
	private final Stack<Integer> stack;
	// 'minStack' is used to store the minimum values in 'stack'.
	private final Stack<Integer> minStack;

	//	Time Complexity O(1) in all methods
//	Space Complexity: O(n)
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);

		// Only push to minStack if the new value is less than or equal to the current minimum.
		if (minStack.isEmpty() || val <= minStack.peek())
			minStack.push(val);
	}

	public void pop() {
		// When popping, check if the popped value is the current minimum.
		if (stack.peek().equals(minStack.peek()))
			minStack.pop(); // Pop from minStack only if it's the minimum value.
		stack.pop(); // Always pop from the main stack.
	}

	public int top() {
		return stack.peek(); // Return the top of the main stack.
	}

	public int getMin() {
		return minStack.peek(); // Return the top of the min stack, the current minimum.
	}

}


