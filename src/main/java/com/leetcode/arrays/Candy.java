package com.leetcode.arrays;

import java.util.Arrays;

public class Candy {

    //    https://leetcode.com/problems/candy/
//    Time complexity: O(n), where n is the number of elements in the input list.
//    Space complexity: O(n), where n is the number of elements in the input list.
    public int candy(int[] ratings) {
        int size = ratings.length;
        int[] candies = new int[size];
        Arrays.fill(candies, 1);
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) // if the current rating is greater than the left rating, then the current candy should be greater than the left candy.
                candies[i] = candies[i - 1] + 1; // to make sure the current candy is greater than the left candy.
        }
        for (int i = size - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) // if the current rating is greater than the right rating, then the current candy should be greater than the right candy.
                candies[i] = Math.max(candies[i], candies[i + 1] + 1); // to make sure the current candy is greater than the right candy.
        }
        int sum = 0;
        for (int candy : candies)
            sum += candy;
        return sum;
    }
}
