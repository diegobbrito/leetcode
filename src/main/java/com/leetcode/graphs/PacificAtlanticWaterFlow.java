package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
//    https://leetcode.com/problems/pacific-atlantic-water-flow/

    //    Depth First Search
//    Time complexity:O(m∗n)
//     Space complexity: O(m∗n)
// Define directions for exploring neighbors: Down, Up, Right, Left
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Get the number of rows and columns in the heights matrix
        int ROWS = heights.length, COLS = heights[0].length;

        // Create two boolean matrices to track cells that can flow to Pacific and Atlantic Oceans
        boolean[][] pac = new boolean[ROWS][COLS]; // For Pacific Ocean
        boolean[][] atl = new boolean[ROWS][COLS]; // For Atlantic Ocean

        // Start DFS for cells adjacent to the Pacific Ocean (top and left borders)
        for (int c = 0; c < COLS; c++) { // Top row (Pacific border)
            dfs(0, c, pac, heights);
        }
        for (int r = 0; r < ROWS; r++) { // Left column (Pacific border)
            dfs(r, 0, pac, heights);
        }

        // Start DFS for cells adjacent to the Atlantic Ocean (bottom and right borders)
        for (int c = 0; c < COLS; c++) { // Bottom row (Atlantic border)
            dfs(ROWS - 1, c, atl, heights);
        }
        for (int r = 0; r < ROWS; r++) { // Right column (Atlantic border)
            dfs(r, COLS - 1, atl, heights);
        }

        // Prepare the result list to store cells that can flow to both oceans
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                // If a cell can flow to both Pacific and Atlantic, add it to the result
                if (pac[r][c] && atl[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }

        return res; // Return the final list of coordinates
    }

    // Depth-First Search (DFS) to mark cells that can flow to a specific ocean
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        // Mark the current cell as reachable for the given ocean
        ocean[r][c] = true;

        // Explore all four directions from the current cell
        for (int[] d : directions) {
            int nr = r + d[0]; // New row after moving in the current direction
            int nc = c + d[1]; // New column after moving in the current direction

            // Check if the new cell is within bounds, not already visited,
            // and has a height >= the current cell (water can flow downhill or level)
            if (nr >= 0 && nr < heights.length && // Check row bounds
                    nc >= 0 && nc < heights[0].length && // Check column bounds
                    !ocean[nr][nc] && // Ensure the cell hasn't been visited yet
                    heights[nr][nc] >= heights[r][c]) { // Ensure water can flow
                dfs(nr, nc, ocean, heights); // Recursive call to explore the new cell
            }
        }
    }

}
