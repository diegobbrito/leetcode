package com.leetcode.arrays;

import java.util.Objects;
import java.util.Stack;

class MinStack {

//	https://leetcode.com/problems/min-stack/
	Stack<Integer> stack;
	Stack<Integer> min;
	public MinStack() {
		stack = new Stack<>();
		min = new Stack<>();
	}

	public void push(int val) {
		if(min.isEmpty())
			min.push(val);
		else if (min.peek() >= val) {
			min.push(val);
		}

		stack.push(val);
	}

	public void pop() {
		if(!stack.isEmpty()){
			var val = stack.pop();
			if(!min.isEmpty() && Objects.equals(min.peek(), val)){
				min.pop();
			}
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		if(!min.isEmpty())
			return min.peek();
		return 0;
	}
}


