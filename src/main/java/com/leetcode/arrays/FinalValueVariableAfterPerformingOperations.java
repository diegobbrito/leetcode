package com.leetcode.arrays;

public class FinalValueVariableAfterPerformingOperations {

    //https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int finalValueAfterOperations(String[] operations) {

        int result = 0;

        for(String operation : operations){
            if(operation.charAt(1) == '+'){
                result++;
            } else {
                result--;
            }
        }

        return result;
    }
}
