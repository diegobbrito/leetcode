package com.leetcode.stack;

import java.util.Stack;

public class MakeTheStringGreat {
//    https://leetcode.com/problems/make-the-string-great/

    //      Time Complexity O(n)
//      Space Complexity O(n)
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (!stack.isEmpty()
                    && stack.peek() != s.charAt(i)
                    && Character.toLowerCase(stack.peek()) == Character.toLowerCase(s.charAt(i))) {

                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }

        return String.valueOf(stack).replaceAll("[^a-zA-Z]", "");
    }

    public static String makeGood2(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (!stack.isEmpty()
                    && stack.peek() != s.charAt(i)
                    && Character.toLowerCase(stack.peek()) == Character.toLowerCase(s.charAt(i))) {

                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
