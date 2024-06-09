package com.leetcode.arrays;

import java.util.Stack;

public class BaseballGame {

//	https://leetcode.com/problems/baseball-game/
	public int calPoints(String[] operations) {
		int[] points = new int[operations.length];
		int index = 0;
		for (String operation : operations) {
			switch (operation) {
				case "C" -> index--;
				case "D" -> points[index] = 2 * points[index++ - 1];
				case "+" -> points[index] = points[index - 1] + points[index++ - 2];
				default -> points[index++] = Integer.parseInt(operation);
			}
		}
		int sum = 0;
		for (int i = --index; i >= 0 ; i--) {
			sum += points[i];
		}
		return sum;
	}

	public int calPointsWithStack(String[] operations) {
		Stack<Integer> stack = new Stack<>();
		for(String step : operations) {
			switch (step) {
				case "+" -> {
					int second = stack.pop();
					int first = stack.peek();
					stack.push(second);
					stack.push(second + first);
				}
				case "D" -> stack.push(stack.peek() * 2);
				case "C" -> stack.pop();
				default -> stack.push(Integer.parseInt(step));
			}
		}
		int sum = 0;
		while (!stack.isEmpty())
			sum += stack.pop();
		return sum;
	}
}
