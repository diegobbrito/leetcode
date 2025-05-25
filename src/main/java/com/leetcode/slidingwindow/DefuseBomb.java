package com.leetcode.slidingwindow;

public class DefuseBomb {

//    https://leetcode.com/problems/defuse-the-bomb/

    //    Time Complexity: O(n * k)
    // Space Complexity: O(n)
    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] result = new int[n];
        if (k == 0)
            return result;

        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int j = i + 1;
                int count = 0;
                while (count < k) {
                    if (j == n) j = 0;
                    sum += code[j];
                    j++;
                    count++;
                }

                result[i] = sum;
            }

        } else {
            k *= -1;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int j = i - 1;
                int count = 0;

                while (count < k) {
                    if (j < 0) j = n - 1;
                    sum += code[j];
                    j--;
                    count++;
                }

                result[i] = sum;
            }
        }

        return result;
    }
}
