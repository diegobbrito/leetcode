package com.leetcode.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
//    https://leetcode.com/problems/task-scheduler/
//    Time Complexity:
//The main loop runs until all tasks are processed, which is at most O(T), where T is the number of tasks.
//Each task might be added and removed from maxHeap and queue, which is O(log T) per operation due to heap operations.
//In the worst case, each task can be processed multiple times with re-insertions to the heap, so the complexity is O(T log T).
//Space Complexity:
//letters array has a fixed size of 26, making it O(1) space.
//maxHeap and queue together can hold up to O(T) elements in the worst case if each task needs to be stored individually during cooldown.
//Overall, the space complexity is O(T) due to the use of maxHeap and queue.

    public int leastInterval(char[] tasks, int n) {
        // If no cooldown period is required, the minimum time is simply the number of tasks
        if (n == 0) return tasks.length;
        // Priority queue (maxHeap) to store the counts of tasks in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Queue to manage tasks that are currently cooling down
        Queue<int[]> queue = new LinkedList<>();
        // Array to count occurrences of each task (assuming tasks are 'A' to 'Z')
        int[] letters = new int[26];
        for (char task : tasks) letters[task - 'A']++;
        // Add task counts to maxHeap (only non-zero values)
        for (int letter : letters)
            if (letter > 0) maxHeap.add(letter);
        int time = 0; // Track the total time required
        // Continue until there are no tasks left in maxHeap or cooling in the queue
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++; // Increment time at each step
            // Process the task with the highest remaining count if available
            if (!maxHeap.isEmpty()) {
                int value = maxHeap.poll(); // Get the highest frequency task
                value--; // Use this task once (decrement its remaining count)
                // If there are still instances of this task left, add it to cooldown queue
                if (value > 0) queue.offer(new int[]{value, time + n});
            }
            // Check if a task has completed its cooldown period
            if (!queue.isEmpty() && queue.peek()[1] == time)
                maxHeap.offer(queue.poll()[0]); // Reinsert task into maxHeap if cooled down
        }
        return time; // Return the total time required to complete all tasks
    }

}
