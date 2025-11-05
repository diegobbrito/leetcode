package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindXSumAllKLongSubarraysI {

//    https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/

//    Time Complexity O(n * Mloglm)
//    Space Complexity O(n)

    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for(int r = 0, l = 0, i = 0; r < n ; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if(r >= k - 1){
                int sum = getSum(map, x);
                result[i++] = sum;
                map.put(nums[l], map.get(nums[l++]) - 1);
            }
        }

        return result;
    }

    private int getSum(Map<Integer,Integer> map, int x){
        PriorityQueue <int[]> queue = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int sum = 0;
        while(x > 0 && !queue.isEmpty()){
            int[] curr = queue.poll();
            sum += curr[0] * curr[1];
            x--;
        }
        return sum;
    }
}
