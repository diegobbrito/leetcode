package com.leetcode.arrays;

public class AddingSpacesString {
    //    https://leetcode.com/problems/adding-spaces-to-a-string/
//    Time Complexity O(n)
//    Memory Complexity O(n)
    public String addSpaces(String s, int[] spaces) {

        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int space : spaces) {
            sb.append(s, start, space).append(" ");
            start = space;
        }
        sb.append(s, start, s.length());
        return sb.toString();
    }
}
