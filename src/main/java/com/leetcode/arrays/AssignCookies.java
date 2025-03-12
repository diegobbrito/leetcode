package com.leetcode.arrays;

import java.util.Arrays;

public class AssignCookies {
    //    https://leetcode.com/problems/assign-cookies/
//    Time Complexity O(GlogG + SlogS + Max g|s)
//    Memory Complexity O(g + s)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int i = 0;
        int gSize = g.length;
        int sSize = s.length;
        while(i < gSize && j < sSize){
            if(g[i] <= s[j]){
                i++;
            } 
            j++;
        }

        return i;        
    }
}
