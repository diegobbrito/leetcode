package com.leetcode.arrays;

import java.util.List;

public class ValidWordSquare {

//    https://leetcode.com/problems/valid-word-square
//    Time Complexity O(m * n)
//    Space Complexity O(1)

    public boolean validWordSquare(List<String> words) {
        int size = words.size();
        for(int i = 0; i < words.size(); i++){
            String word = words.get(i);
            if(size < word.length()){
                return false;
            }
            int j = 0;
            for(char c : word.toCharArray()){
                if(i >= words.get(j).length() || c != words.get(j).charAt(i)){
                    return false;
                }
                j++;
            }
        }
        return true;
    }
}
