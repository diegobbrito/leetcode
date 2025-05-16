package com.leetcode.intervals;

import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(o -> o.start));
        int end = 0;
        for (Interval interval : intervals) {
            if (interval.start < end) {
                return false;
            }
            end = interval.end;
        }
        return true;
    }
}
