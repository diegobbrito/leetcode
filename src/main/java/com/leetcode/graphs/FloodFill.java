package com.leetcode.graphs;

public class FloodFill {
//    https://leetcode.com/problems/flood-fill/

    //    Time Complexity:
//    O(n * m), where n is the number of rows and m is the number of columns in the image.
//    In the worst case, every pixel might be visited once if they all have the same color as the starting pixel.
//    Space Complexity:
//    O(n * m), which accounts for the recursion stack.
//    In the worst case, if the fill operation spreads to all pixels,
//    the depth of the recursion could be equal to the number of pixels, which is n \* m.
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Get the color of the starting pixel
        var startingPixel = image[sr][sc];
        // Call the helper function to perform depth-first search (DFS) and fill the image
        dfs(image, sr, sc, color, startingPixel);
        // Return the modified image
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int startingPixel) {
        // Check if the current pixel is out of bounds or has already been filled with the target color
        // or is not the same as the starting pixel's color
        if (sr < 0 || sr >= image.length // Check row boundaries
                || sc < 0 || sc >= image[0].length // Check column boundaries
                || image[sr][sc] == color // Already filled with the target color
                || image[sr][sc] != startingPixel) { // Not the same color as the starting pixel
            return; // Stop the DFS here
        }

        // Fill the current pixel with the new color
        image[sr][sc] = color;

        // Recursively call DFS on the adjacent pixels (up, down, left, right)
        dfs(image, sr - 1, sc, color, startingPixel); // Up
        dfs(image, sr + 1, sc, color, startingPixel); // Down
        dfs(image, sr, sc - 1, color, startingPixel); // Left
        dfs(image, sr, sc + 1, color, startingPixel); // Right
    }

}
