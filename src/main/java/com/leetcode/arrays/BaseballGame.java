package com.leetcode.arrays;

import java.util.Stack;

public class BaseballGame {

//	https://leetcode.com/problems/baseball-game/
	public static int calPoints(String[] operations) {
		int[] points = new int[operations.length];
		int count = 0;
		for (String operation : operations) {
			switch (operation) {
				case "C" -> count--;
				case "D" -> {
					points[count] = 2 * points[count - 1];
					count++;
				}
				case "+" -> {
					points[count] = points[count - 1] + points[count - 2];
					count++;
				}
				default ->{
					points[count] = Integer.parseInt(operation);
					count++;
				}
			}
		}
		int sum = 0;
		for (int i = --count; i >= 0 ; i--) {
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
