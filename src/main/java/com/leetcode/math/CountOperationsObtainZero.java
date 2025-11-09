package com.leetcode.math;

public class CountOperationsObtainZero {

//    https://leetcode.com/problems/count-operations-to-obtain-zero
//    Time Complexity O(min(n1,n2))
//    Space Complexity O(1)

    public int countOperations(int num1, int num2) {
        int operations = 0;

        while(num1 != 0 && num2 != 0){
            operations++;
            if(num1 >= num2){
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        return operations;
    }
}
