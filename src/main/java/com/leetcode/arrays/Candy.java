package com.leetcode.arrays;

public class Candy {

    //    https://leetcode.com/problems/candy/
//    Time complexity: O(n), where n is the number of elements in the input list.
//    Space complexity: O(n), where n is the number of elements in the input list.
    public int candy(int[] ratings) {
        int size = ratings.length;
        int[] candies = new int[size];
        for (int i = 0; i < size; i++) {
            candies[i] = 1;
        }
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = size - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
