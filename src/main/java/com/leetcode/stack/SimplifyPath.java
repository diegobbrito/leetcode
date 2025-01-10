package com.leetcode.stack;

import java.util.Stack;

public class SimplifyPath {

    //    https://leetcode.com/problems/simplify-path/
//    Time complexity: O(n)
//    Space complexity: O(n)
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String p : paths) {
            if (p.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!p.equals(".") && !p.isEmpty())
                stack.push(p);
        }

//        for(String s : stack)
//            result.append("/").append(s);
        Stack<String> newStack = new Stack<>();
        while (!stack.isEmpty())
            newStack.push(stack.pop());
        while (!newStack.isEmpty())
            result.append("/").append(newStack.pop());
        return result.isEmpty() ? "/" : result.toString();
    }

}
