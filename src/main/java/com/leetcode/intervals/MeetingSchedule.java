package com.leetcode.intervals;

import java.util.Comparator;
import java.util.List;

public class MeetingSchedule {
//    https://neetcode.io/problems/meeting-schedule

    //    Brute Force
//    Time Complexity O(n²)
//    Memory Complexity O(1)
    public boolean canAttendMeetings(List<Interval> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval interval1 = intervals.get(j);
                if (interval.end > interval1.start && interval1.end > interval.start)
                    return false;
            }
        }
        return true;
    }

    //   Sorting
//    Time Complexity O(nlogn)
//    Memory Complexity O(n) due to the sorting process.
    public boolean canAttendMeetingsSort(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        int end = 0;
        for (Interval interval : intervals) {
            if (interval.start < end)
                return false;
            end = interval.end;
        }
        return true;
    }

    static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

