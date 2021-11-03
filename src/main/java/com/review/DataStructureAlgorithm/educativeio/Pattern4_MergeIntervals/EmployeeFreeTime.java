//Incomplete
// package com.review.ds.educativeio.Pattern4_MergeIntervals;
///*
//Employee Free Time (hard) #
//For ‘K’ employees, we are given a list of intervals representing the working hours of each employee. Our goal is to find out if there is a free interval that is common to all employees. You can assume that each list of employee working hours is sorted on the start time.
//
//Example 1:
//
//Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
//Output: [3,5]
//Explanation: Both the employess are free between [3,5]
// */
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.PriorityQueue;
//
//class EmployeeInterval {
//    Interval interval;
//    int employeeIndex;
//    int intervalIndex;
//
//    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
//        this.interval = interval;
//        this.employeeIndex = employeeIndex;
//        this.intervalIndex = intervalIndex;
//    }
//}
//
//
//
//public class EmployeeFreeTime {
//    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
//        List<Interval> result = new ArrayList<>();
//
//        // Priority Queue to store one interval for each employee
//        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.interval.start, b.interval.start));
//
//        // insert the first interval of each employee to the queue
//        for (int i = 0; i < schedule.size(); i++) {
//            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
//        }
//
//        Interval previousInterval = minHeap.peek().interval;
//
//        while(!minHeap.isEmpty()) {
//            EmployeeInterval queueTop = minHeap.poll();
//
//            // if previous Interval is not overlapping with the next interval, insert a free interval
//            if (previousInterval.end < queueTop.interval.start) {
//                result.add(new Interval(previousInterval.end, queueTop.interval.start));
//
//            }
//
//
//        }
//
//
//        return  result;
//    }
//
//
//
//    public static void main(String[] args) {
//        List<List<Interval>> input = new ArrayList<>();
//        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
//        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2,3), new Interval(6, 8))));
//        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
//        System.out.println("Free intervals");
//        for(Interval interval: result) {
//            System.out.println("[" + interval.start + ", " + interval.end + "] ");
//        }
//
//    }
//
//}
