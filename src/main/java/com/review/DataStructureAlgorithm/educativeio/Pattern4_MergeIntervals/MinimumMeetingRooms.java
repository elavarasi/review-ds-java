package com.review.DataStructureAlgorithm.educativeio.Pattern4_MergeIntervals;
/*
Minimum Meeting Rooms (hard) #
Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.

Example 1:

Meetings: [[1,4], [2,5], [7,9]]
Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
occur in any of the two rooms later.
 */

import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};



public class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {

        // If no meetings return 0 rooms
        if (meetings == null || meetings.size() == 0) {
            return 0;
        }

        // First sort the meetings by start time
        Collections.sort(meetings, Comparator.comparingInt(a -> a.start));

        int minRoom = 0;
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));

        for(Meeting meeting: meetings) {
            // Remove all meetings that has ended
            while(!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }

            // Add current meeting into the minHeap
            minHeap.offer(meeting);

            // All active meetings are in the min Heap, so we need the room for all of them.
            minRoom = Math.max(minHeap.size(), minRoom);
        }

        return minRoom;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
