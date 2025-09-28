package com.leetcode.twopointers;

public class CompareVersionNumbers {


    // https://leetcode.com/problems/compare-version-numbers/
    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    public int compareVersion(String version1, String version2) {
        final String[] levels1 = version1.split("\\.");
        final String[] levels2 = version2.split("\\.");
        final int length = Math.max(levels1.length, levels2.length);

        for (int i = 0; i < length; ++i) {
            final Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            final Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            final int compare = v1.compareTo(v2);
            if (compare != 0)
                return compare;
        }

        return 0;
    }

    // Two pointers approach
    public int compareVersionTwoPointers(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            int v1 = 0;
            while (i < n1 && version1.charAt(i) != '.') {
                v1 = v1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++; // skip the dot

            int v2 = 0;
            while (j < n2 && version2.charAt(j) != '.') {
                v2 = v2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++; // skip the dot

            if (v1 != v2) {
                return Integer.compare(v1, v2);
            }
        }
        return 0;
    }
}
