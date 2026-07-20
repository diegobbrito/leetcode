package com.leetcode.greedy;

import java.util.Arrays;

public class MinimumNumberMovesSeatEveryone {

//    https://neetcode.io/problems/minimum-number-of-moves-to-seat-everyone/

//    Time Complexity: O(nlogn)
//    Space Complexity: O(1) if we ignore the space used by the sorting algorithm.

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for(int i = 0; i < seats.length; i++){
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }
}
