package com.review.DataStructureAlgorithm.educativeio.Pattern4_MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement #
Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.

Example 1:

Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]
Explanation: The output list contains the common intervals between the two lists.
Example 2:

Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
Output: [5, 7], [9, 10]
Explanation: The output list contains the common intervals between the two lists.
 */
public class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        int i = 0;
        int j = 0;


        while (i < arr1.length && j < arr2.length) {
            // Does a overlaps b
            boolean a_overlaps_b = arr1[i].start <= arr2[j].end && arr1[i].start >= arr2[j].end;

            // Does b overlaps a
            boolean b_overlaps_b = arr2[j].start <= arr1[i].end && arr2[j].start >= arr1[i].start;

            // Push the overlap interval
            if (a_overlaps_b || b_overlaps_b) {
                int start = Math.max(arr1[i].start, arr2[j].start);
                int end = Math.min(arr1[i].end, arr2[j].end);
                intervalsIntersection.add(new Interval(start, end));
            }

            // Increment the interval that ends first
            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }

}
