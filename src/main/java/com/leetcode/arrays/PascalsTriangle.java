package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

//    https://neetcode.io/problems/pascals-triangle/
//    Time Complexity O(n2)
//    Memory Complexity O(n2)

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    curr.add(1);
                } else {
                    curr.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
            }
            result.add(curr);
        }
        return result;
    }
}
