package com.leetcode.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindromeTwoPointers("bana  @anab"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeTwoPointers(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if (isNotAlphanumeric(start)) {
                i++;
                continue; // Used instead another while loop
            }
            if (isNotAlphanumeric(end)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(start) != Character.toLowerCase(end))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private static boolean isNotAlphanumeric(char character) {
        return (character < 'a' || character > 'z') &&
                (character < 'A' || character > 'Z') &&
                (character < '0' || character > '9');
    }

    //    Time Complexity O(n)
//    Space Complexity O(1)
    public boolean isPalindrome3(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!validCharacter(s.charAt(left))) {
                left++;
                continue;
            }
            if (!validCharacter(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--)))
                return false;
        }
        return true;
    }

    private boolean validCharacter(char value) {
        return (value >= 'a' && value <= 'z') ||
                (value >= 'A' && value <= 'Z') ||
                (value >= '0' && value <= '9');
    }
}
