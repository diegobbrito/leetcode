package com.leetcode.sorting;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

//    https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
    //Time complexity: O(nlogn), Space complexity: O(1)

    @Override
    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        return a.score > b.score ? -1 : 1;
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
