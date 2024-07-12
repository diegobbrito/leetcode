package com.leetcode.stack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    //    Time complexity O(n)
    //    Memory complexity O(n)
    public static int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] response = new int[size];
        Stack<Integer> stack = new Stack<>();
        for (int currentDayIndex = 0; currentDayIndex < size; currentDayIndex++) {
            //  Check if the stack has a value and
            //  if the temperature at the current index is more than the temperature
            //  at the index in the top of the stack
            while (!stack.isEmpty() && temperatures[currentDayIndex] > temperatures[stack.peek()]) {
                // Get the index where the temperature is less than the current
                int previousDayIndex = stack.pop();
                // Add to the response the result of the index of the current day less the index of previous day
                response[previousDayIndex] = currentDayIndex - previousDayIndex;
            }
            stack.push(currentDayIndex); // Add the index of the days
        }
        return response;
    }

    //    https://leetcode.com/problems/daily-temperatures/
//    Time complexity O(n²)
//    Memory complexity O(n)
    public int[] dailyTemperatures2(int[] temperatures) {
        int size = temperatures.length;
        int[] response = new int[size];
        for (int i = 0; i < size - 1; i++) {
            int countDays = 0;
            boolean check = false;
            for (int j = i + 1; j < size; j++) {
                countDays++;
                if (temperatures[i] < temperatures[j]) {
                    check = true;
                    break;
                }
            }
            response[i] = check ? countDays : 0;
        }
        return response;
    }
}
