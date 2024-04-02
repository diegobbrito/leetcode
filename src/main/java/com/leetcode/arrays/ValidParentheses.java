package com.leetcode.arrays;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("(){}}{"));
	}
	public static boolean isValid(String s) {

//		https://leetcode.com/problems/valid-parentheses/submissions/1220612692/

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			var letter = s.charAt(i);
			switch (letter){
				case '{', '[', '(' -> stack.push(letter);
				case '}' -> {
					if(stack.isEmpty() || '{' != stack.pop())
						return false;
				}
				case ')' -> {
					if(stack.isEmpty() || '(' != stack.pop())
						return false;
				}
				case ']' -> {
					if(stack.isEmpty() || '[' != stack.pop())
						return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
