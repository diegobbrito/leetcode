package com.leetcode.greedy;

public class MinimumTimeMakeRopeColorful {

//    https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
//    Time Complexity O(n)
//    Space Complexity O(1)

    public int minCost(String colors, int[] neededTime) {
        int result = 0;

        for(int i = 0; i < colors.length(); i++){
            char c = colors.charAt(i);
            int j = i + 1;
            int sum = neededTime[i];
            int max = neededTime[i];
            while(j < colors.length() && c == colors.charAt(j)){
                sum += neededTime[j];
                max = Math.max(max, neededTime[j]);
                j++;
            }
            if(sum != neededTime[i]){
                result += sum - max;
                i = j - 1;
            }
        }

        return result;
    }
}
