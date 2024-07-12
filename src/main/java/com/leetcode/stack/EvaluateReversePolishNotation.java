package com.leetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    //    https://leetcode.com/problems/evaluate-reverse-polish-notation/
//    Time Complexity O(n)
//    Memory complexity O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    var temp = stack.pop();
                    stack.push(stack.pop() - temp);
                }
                case "/" -> {
                    var temp = stack.pop();
                    stack.push(stack.pop() / temp);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
