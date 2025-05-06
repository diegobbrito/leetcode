package com.leetcode.arrays;

public class NumberSeniorCitizens {

    //https://leetcode.com/problems/number-of-senior-citizens/
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int countSeniors(String[] details) {
        int res = 0;
        for (String d : details) {
            if (Integer.parseInt(d.substring(11, 13)) > 60) {
                res++;
            }
        }
        return res;
    }
}
