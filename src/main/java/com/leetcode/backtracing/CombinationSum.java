package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
//    https://leetcode.com/problems/combination-sum/description/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> response = new ArrayList<>();
        dfsBacktracing(candidates, target, response, new ArrayList<>(), 0);
        return response;
    }

    private void dfsBacktracing(int[] candidates, int target, List<List<Integer>> response, List<Integer> current, int index) {
        if(target == 0) response.add(List.copyOf(current));
        else if (target < 0 || index >= candidates.length) {
            return;
        } else {
          current.add(candidates[index]);
          dfsBacktracing(candidates, target - candidates[index], response, current, index);
          current.remove(current.get(current.size() - 1));
          dfsBacktracing(candidates, target, response, current, index + 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> currentSum, int [] nums, int remain, int start){
        if(remain == 0) list.add(new ArrayList<>(currentSum));
        else if(remain > 0) {
            for(int i = start; i < nums.length; i++){
                currentSum.add(nums[i]);
                backtrack(list, currentSum, nums, remain - nums[i], i);
                currentSum.remove(currentSum.size() - 1);
            }
        }
    }

}
