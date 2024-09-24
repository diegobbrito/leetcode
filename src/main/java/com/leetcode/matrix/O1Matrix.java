package com.leetcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class O1Matrix {
    //    https://leetcode.com/problems/01-matrix/
//  Time Complexity: O(m * n)
// where m is the number of rows and n is the number of columns. Each cell is processed once in the BFS.
//  Space Complexity: O(m * n)
// for storing the distance matrix and the BFS queue.
    public int[][] updateMatrix(int[][] mat) {
        // Get the dimensions of the matrix
        int rows = mat.length;
        int cols = mat[0].length;

        // Initialize the result matrix with MAX_VALUE for '1's and '0' for '0's
        int[][] dist = new int[rows][cols];

        // Initialize the queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Populate the queue with all 0s and set the distances for them
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    dist[r][c] = 0; // Distance to itself is 0
                    queue.offer(new int[]{r, c}); // Add position of 0 to the queue
                } else {
                    dist[r][c] = Integer.MAX_VALUE; // Mark '1's as infinity (unreachable for now)
                }
            }
        }

        // Define directions for moving up, down, left, and right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: Perform BFS to update distances
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];

            // Explore all four directions (up, down, left, right)
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    // If the current distance + 1 is smaller than the neighbor's distance
                    if (dist[newRow][newCol] > dist[r][c] + 1) {
                        dist[newRow][newCol] = dist[r][c] + 1; // Update the distance
                        queue.offer(new int[]{newRow, newCol}); // Add the neighbor to the queue
                    }
                }
            }
        }

        // Step 3: Return the final distance matrix
        return dist;
    }
}
