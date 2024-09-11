package com.leetcode.stack;

import java.util.Stack;

public class ImplementQueueStacks {
//    https://leetcode.com/problems/implement-queue-using-stacks/

//    Time Complexity
//Push Operation:
//Time Complexity: O(1)
//Each push operation simply adds an element to stack1, which takes constant time.

//Pop Operation:
//Time Complexity: Amortized O(1), Worst-case O(n)
//The worst-case scenario occurs when stack2 is empty and we need to move all elements from stack1 to stack2.
// This operation takes O(n) time, where n is the number of elements in the queue.
// However, each element is moved from stack1 to stack2 at most once, so the amortized cost per pop operation is O(1).

//Peek Operation:
//Time Complexity: Amortized O(1), Worst-case O(n)
//The logic is the same as pop(). We only move elements when stack2 is empty, resulting in an amortized time complexity of O(1).

//Empty Operation:
//Time Complexity: O(1)
//Checking if both stacks are empty is a constant-time operation.

    //Space Complexity
//Space Complexity: O(n)
//The space complexity is O(n) where n is the number of elements in the queue,
// as all elements are stored in either stack1 or stack2. There is no additional space used apart from the two stacks.
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

//        public int pop() {
//            while(!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }
//            var temp = stack2.pop();
//            while(!stack2.isEmpty()) {
//                stack1.push(stack2.pop());
//            }
//            return temp;
//        }
//
//        public int peek() {
//            while(!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }
//            var temp = stack2.peek();
//            while(!stack2.isEmpty()) {
//                stack1.push(stack2.pop());
//            }
//            return temp;
//        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
