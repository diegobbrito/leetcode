package com.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
//	https://leetcode.com/problems/rotting-oranges/

//	Time Complexity O(n*m)
//	Space Complexity O(n*m)
	public int orangesRotting(int[][] grid) {

		int rows = grid.length;
		int cols = grid[0].length;
		int time = 0, freshOranges = 0;

		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(1 == grid[i][j])
					freshOranges++;
				else if (2 == grid[i][j])
					queue.offer(new int[]{i, j});
			}
		}
		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		//	BFS
		while(!queue.isEmpty() && freshOranges > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();
				int r = current[0], c = current[1];
				for (int[] dir : directions) {
					int row = r + dir[0];
					int col = c + dir[1];
					if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
						grid[row][col] = 2;
						queue.offer(new int[]{row, col});
						freshOranges--;
					}
				}
			}
			time++;
		}
		return freshOranges == 0 ? time : -1;
	}
}
