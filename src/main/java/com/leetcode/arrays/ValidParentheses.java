package com.leetcode.arrays;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("(){}}{"));
	}
//		https://leetcode.com/problems/valid-parentheses/

//    Time complexity O(n)
//    Space Complexity O(n)
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int size = s.length();
		for (int i = 0; i < size; i++) {
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
