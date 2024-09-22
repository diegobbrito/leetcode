package com.leetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    //    https://leetcode.com/problems/evaluate-reverse-polish-notation/
//    Time Complexity O(n)
//    Memory complexity O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // Initialize a stack to store operands.

        for (String token : tokens) { // Iterate through each token in the input array.
            switch (token) {
                case "*" ->
                    // Pop two elements from the stack, multiply them, and push the result back.
                        stack.push(stack.pop() * stack.pop());
                case "+" ->
                    // Pop two elements from the stack, add them, and push the result back.
                        stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    // Pop the first element (second operand), pop the second element (first operand),
                    // subtract the first from the second, and push the result back.
                    var temp = stack.pop();
                    stack.push(stack.pop() - temp);
                }
                case "/" -> {
                    // Similar to subtraction, pop the second operand, then the first, divide the first by the second,
                    // and push the result back.
                    var temp = stack.pop();
                    stack.push(stack.pop() / temp);
                }
                default ->
                    // If the token is not an operator, it must be a number. Parse it as an integer and push it onto the stack.
                        stack.push(Integer.parseInt(token));
            }
        }
        // The last element remaining in the stack is the result of evaluating the RPN expression.
        return stack.pop();
    }
}
