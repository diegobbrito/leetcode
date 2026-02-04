package com.leetcode.searching;

public class FindSmallestLetterGreaterThanTarget {

//    https://leetcode.com/problems/find-smallest-letter-greater-than-target
//    Time Complexity O(n)
//    Space Complexity O(1)
    public char nextGreatestLetter(char[] letters, char target) {

        for(char letter : letters){
            if(target < letter){
                return letter;
            }
        }
        return letters[0];
    }

}
