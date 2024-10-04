package com.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberIslands {
//	https://leetcode.com/problems/number-of-islands/

//	Depth-First Search (DFS):
//	Time Complexity: O(m*n)
//	Space Complexity: O(m*n)
	public int numIslands(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int numberOfInslands = 0;

//		Iterate for every value in the graph, searching for number 1
//		if it's find, increment the number of island and call dfs function
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if('1' == grid[i][j]){
					numberOfInslands++;
					dfs(i, j, grid);
				}
			}
		}
		return numberOfInslands;
	}

	private void dfs(int i, int j, char[][] grid) {
//	If the cell is out of the grid boundaries or not land ('1'), return.
		if(i < 0 || i >= grid.length
				|| j < 0 || j >= grid[0].length
				|| '1' != grid[i][j]){
			return;
		} else {
//			Mark the current cell as visited by changing it from '1' to '0'.
			grid[i][j] = '0';
			// Recursively call DFS for the neighboring cells (up, down, left, right) to explore
			// and mark all connected land cells.
			dfs(i, j + 1, grid);
			dfs(i, j - 1, grid);
			dfs(i + 1, j, grid);
			dfs(i - 1, j, grid);
		}
	}

//	Breadth-First Search (BFS):
class Solution {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) return 0;

		int numIslands = 0, m = grid.length, n = grid[0].length;
		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					numIslands++;
					queue.offer(new int[]{i, j});

					while (!queue.isEmpty()) {
						int[] curr = queue.poll();
						int x = curr[0], y = curr[1];

						if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1')
							continue;

						grid[x][y] = '0'; // mark as visited

						for (int[] dir : directions) {
							int nx = x + dir[0];
							int ny = y + dir[1];
							if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1')
								queue.offer(new int[]{nx, ny});
						}
					}
				}
			}
		}

		return numIslands;
	}
}
}
