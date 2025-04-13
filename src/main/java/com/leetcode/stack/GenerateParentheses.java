package com.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Stack to keep track of the current combination of parentheses
        Stack<Character> stack = new Stack<>();
        // Start the backtracking process with initial values
        backTracking(0, 0, n, stack, result);
        return result;
    }

    // Helper method to perform backtracking
    private void backTracking(int openN, int closedN, int n, Stack<Character> stack, List<String> result) {
        // Base case: if the number of open and closed parentheses is equal to 'n'
        if (openN == n && closedN == n) {
            // Add the current combination to the result list
            result.add(stack.toString().replaceAll("[^()]", ""));
        }

        // If the number of open parentheses is less than 'n', add an open parenthesis
        if (openN < n) {
            stack.push('(');
            // Backtrack and removing the last added open parenthesis
            backTracking(openN + 1, closedN, n, stack, result);
            stack.pop();
        }

        // If the number of closed parentheses is less than the number of open ones, add a closed parenthesis
        if (closedN < openN) {
            stack.push(')');
            // Backtrack and removing the last added closed parenthesis
            backTracking(openN, closedN + 1, n, stack, result);
            stack.pop();
        }
    }
}
