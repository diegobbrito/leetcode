package com.leetcode.arrays;

public class Onebit2bitCharacters {

//    https://leetcode.com/problems/1-bit-and-2-bit-characters/
//    Time Complexity O(n)
//    Space Complexity O(1)

    public boolean isOneBitCharacter(int[] bits) {

        boolean result = false;
        for(int i = 0; i < bits.length; i++){
            if(bits[i] == 1){
                result = false;
                i++;
            } else {
                result = true;
            }
        }

        return result;
    }
}
