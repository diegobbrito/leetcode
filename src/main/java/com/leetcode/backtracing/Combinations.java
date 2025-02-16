package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    List<List<Integer>> result;
    int k;
    int n;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        result = new ArrayList<>();
        backtrack(1, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, List<Integer> curr) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
