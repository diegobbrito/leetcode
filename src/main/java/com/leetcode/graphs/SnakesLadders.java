package com.leetcode.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesLadders {

    // https://leetcode.com/problems/snakes-and-ladders/
    // Time complexity: O(n^2)
    // Space complexity: O(n^2)

    public int snakesAndLadders(int[][] board) {
        int[] movesP = new int[]{1, 2, 3, 4, 5, 6};

        int size = board.length;
        int boardSize = size * size;


        Set<Integer> visit = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int square = cur[0], moves = cur[1];
            for (int m : movesP) {
                int nextSquare = square + m;
                int[] pos = intToPos(nextSquare, size);
                int r = pos[0], c = pos[1];
                if (board[r][c] != -1) {
                    nextSquare = board[r][c];
                }
                if (nextSquare == boardSize)
                    return moves + 1;
                if (!visit.contains(nextSquare)) {
                    visit.add(nextSquare);
                    queue.offer(new int[]{nextSquare, moves + 1});
                }
            }

        }
        return -1;
    }

    private int[] intToPos(int square, int n) {
        int r = (square - 1) / n;
        int c = (square - 1) % n;
        if (r % 2 == 1) c = n - 1 - c;
        r = n - 1 - r;
        return new int[]{r, c};
    }
}
