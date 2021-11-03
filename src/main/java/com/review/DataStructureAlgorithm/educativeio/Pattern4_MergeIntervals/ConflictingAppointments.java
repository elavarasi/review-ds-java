package com.review.DataStructureAlgorithm.educativeio.Pattern4_MergeIntervals;

import java.util.Arrays;

/*
Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

Example 1:

Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
Example 2:

Appointments: [[6,7], [2,4], [8,12]]
Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.
Example 3:

Appointments: [[4,5], [2,3], [3,6]]
Output: false
Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.

 */
public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        //First we sort the intervals by start time of the meeting
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start) );

        int i = 1;
        //Iterate if start is between start and end of previous.
        // Key is we should check < and not <= at a meeting can start right after another meeting ends
        while(i < intervals.length) {
            if(intervals[i].start > intervals[i-1].start && intervals[i].start < intervals[i-1].end) {
                return false; // there is conflict between intervals
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }


}
