package com.leetcode.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FraudulentActivityNotifications {

    //https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem

    //Time complexity: O(nlogd), Space complexity: O(d)
    public static int activityNotifications(List<Integer> expenditure, int d) {

        int count = 0;
        for (int left = 0, right = d; right < expenditure.size(); right++, left++) {
            double median = getMedian(expenditure, left, right - 1, d);
            System.out.println(median);
            if (expenditure.get(right) >= median * 2)
                count++;
        }
        return count;
    }

    private static double getMedian(List<Integer> expenditure, int left, int right, int d) {
        List<Integer> arr = new ArrayList<>();
        while (left < right) {
            arr.add(expenditure.get(left++));
        }
        arr.sort(Comparator.comparingInt(a -> a));
        int mid = d / 2;
        if (d % 2 == 1)
            return (double) arr.get(mid);
        return (arr.get(mid) + arr.get(mid - 1)) / 2.0;
    }


    class Solution {

        // Time complexity: O(n * k), Space complexity: O(k)
        public static int activityNotifications(List<Integer> expenditure, int d) {
            int[] count = new int[201];
            int notifications = 0;

            for (int i = 0; i < d; i++) {
                count[expenditure.get(i)]++; // count the number of occurrences of each element
            }

            for (int i = d, left = 0; i < expenditure.size(); i++, left++) {
                double median = getMedian(count, d);
                if (expenditure.get(i) >= 2 * median) {
                    notifications++;
                }

                count[expenditure.get(i)]++;
                count[expenditure.get(left)]--;
            }
            return notifications;
        }

        private static double getMedian(int[] count, int d) {
            int sum = 0; // sum of the elements
            int mid1 = -1, mid2 = -1; // the two middle elements

            if (d % 2 == 0) {
                for (int i = 0; i < count.length; i++) {
                    sum += count[i];
                    if (mid1 == -1 && sum >= d / 2) {
                        mid1 = i;
                    }
                    if (sum >= d / 2 + 1) {
                        mid2 = i;
                        break;
                    }
                }
                return (mid1 + mid2) / 2.0;
            } else {
                for (int i = 0; i < count.length; i++) {
                    sum += count[i];
                    if (sum > d / 2) {
                        return i;
                    }
                }
            }
            return 0;
        }
    }


}
