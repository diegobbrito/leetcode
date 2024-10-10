package com.leetcode.linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberStudentsUnableEatLunch {
//	https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

	public static int countStudents(int[] students, int[] sandwiches) {
		Stack<Integer> sandwichesStack =  new Stack<>();
		Queue<Integer> studentsQueue = new LinkedList<>();

		int j = sandwiches.length -1;
		for (int k : students) {
			studentsQueue.offer(k);
			sandwichesStack.push(sandwiches[j--]);
		}

		var studentsThatHadAte = 0;
		while (!studentsQueue.isEmpty() && studentsThatHadAte < studentsQueue.size()){

			if(studentsQueue.peek().equals(sandwichesStack.peek())){
				sandwichesStack.pop();
				studentsThatHadAte = 0;
			} else {
				studentsQueue.offer(studentsQueue.peek());
				studentsThatHadAte++;
			}
			studentsQueue.poll();
		}
		return studentsQueue.size();
	}

}
