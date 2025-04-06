package com.leetcode.stack;

import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    //https://www.hackerrank.com/challenges/balanced-brackets/problem
    //Time complexity: O(n)
    //Space complexity: O(n)

    public static String isBalanced(String s) {

        Map<Character, Character> brackets = Map.of(
                ')', '(', ']', '[', '}', '{'
        );

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty() || brackets.get(c) != stack.pop()) {
                return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
