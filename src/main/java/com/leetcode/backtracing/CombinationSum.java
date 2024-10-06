package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
//    https://leetcode.com/problems/combination-sum/description/
//n be the number of elements in the candidates array.
//T be the target value.
//The worst case occurs when every element is repeatedly chosen, leading to an exponential number of calls,
// so the time complexity can be expressed as O(T^n).

    //    Additional Space for Storing Combinations: Each valid combination is stored in the response list.
//    The total number of combinations can be large, especially if the target value is large
//    and the number of candidates is high. So, the space complexity for storing results is O(T \times k), where
//      k is the average length of a combination.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // The result list that will store all valid combinations
        List<List<Integer>> response = new ArrayList<>();
        // Start backtracking using DFS from the first index
        dfsBacktracing(candidates, target, response, new ArrayList<>(), 0);
        // Return the list of all valid combinations
        return response;
    }

    private void dfsBacktracing(int[] candidates, int target, List<List<Integer>> response, List<Integer> current, int index) {
        // Base case: if target is 0, we found a valid combination
        if (target == 0) {
            response.add(List.copyOf(current));  // Add a copy of the current combination to the result list
        }
        // If target becomes negative or index exceeds the array bounds, backtrack (invalid case)
        else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            // Choose the current element (candidates[index])
            current.add(candidates[index]);
            // Recursive call: continue searching with the same element (allow duplicates) and reduce the target
            dfsBacktracing(candidates, target - candidates[index], response, current, index);
            // Backtrack: remove the last added element
            current.remove(current.get(current.size() - 1));
            // Recursive call: try the next element without adding the current element again
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
