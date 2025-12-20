package com.leetcode.arrays;

public class DeleteColumnsMakeSorted {

//    https://leetcode.com/problems/delete-columns-to-make-sorted

//    Time Complexity O(m x n)
//    Space Complexity O(1)

    public int minDeletionSize(String[] strs) {
        int result = 0;

        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
