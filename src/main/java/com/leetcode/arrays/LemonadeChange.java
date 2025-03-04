package com.leetcode.arrays;

public class LemonadeChange {

    //    https://leetcode.com/problems/lemonade-change/

//    Time complexity: O(n)
//    Space complexity: O(1).
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i = 0, size = bills.length; i < size; i++){
            if(bills[i] == 5) five++;
            else if (bills[i] == 10){
                if(five > 0){
                    ten++;
                    five--;
                } else {
                    return false;
                }
            } else {
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                } else if (five > 2){
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
