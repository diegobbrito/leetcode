package com.leetcode.twopointers;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution.backspaceCompare("xywrrmp", "xywrrm#p");
    }

    //    https://leetcode.com/problems/backspace-string-compare/
//    Time Complexity O(n+m)
//    Memory Complexity O(n+m)
    public boolean backspaceCompare(String s, String t) {
        s = removeBackspace(s);
        t = removeBackspace(t);
        return s.equals(t);
    }

    private String removeBackspace(String word) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < word.length()) {
            if (word.charAt(i) == '#') {
                if (!sb.isEmpty())
                    sb.deleteCharAt(sb.length() - 1);
                i++;
            } else
                sb.append(word.charAt(i++));
        }
        return sb.toString();
    }

    class Solution {
        //    Time Complexity O(n+m)
        //    Memory Complexity O(1)
        public static boolean backspaceCompare(String s, String t) {
            int i = s.length() - 1, j = t.length() - 1;

            while (i >= 0 || j >= 0) {
                i = nextValidChar(s, i);
                j = nextValidChar(s, j);
                char sc = i >= 0 ? s.charAt(i) : ' ';
                char tc = j >= 0 ? t.charAt(j) : ' ';
                if (sc != tc) {
                    return false;
                }
                i--;
                j--;
            }

            return true;
        }

        private static int nextValidChar(String s, int index) {
            int backspace = 0;
            while (index >= 0) {
                if (backspace == 0 && s.charAt(index) != '#')
                    break;
                else if (s.charAt(index) == '#')
                    backspace++;
                else
                    backspace--;
                index--;
            }
            return index;
        }
    }
}
