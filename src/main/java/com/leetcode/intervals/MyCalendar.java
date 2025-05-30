package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    // https://leetcode.com/problems/my-calendar-i/
    // Time complexity: O(n)
    // Space complexity: O(n)

    private List<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] event : events) {
            if (startTime < event[1] && event[0] < endTime) {
                return false;
            }
        }
        events.add(new int[]{startTime, endTime});
        return true;
    }
}
