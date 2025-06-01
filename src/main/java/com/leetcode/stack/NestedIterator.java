package com.leetcode.stack;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    private Stack<Integer> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        dfs(nestedList);
        Collections.reverse(stack);
    }

    private void dfs(List<NestedInteger> nested) {
        for (NestedInteger num : nested) {
            if (num.isInteger()) {
                stack.push(num.getInteger());
            } else {
                dfs(num.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}
