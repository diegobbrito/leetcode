package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
//    https://leetcode.com/problems/path-crossing/

    //    Time complexity: O(n)
//    Space complexity: O(n)
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int col = 0, row = 0;
        set.add(col + " " + row);
        for (char ch : path.toCharArray()) {
            switch (ch) {
                case 'N' -> row++;
                case 'S' -> row--;
                case 'E' -> col++;
                case 'W' -> col--;
            }
            if (!set.add(col + " " + row)) {
                return true;
            }
        }
        return false;
    }
}
