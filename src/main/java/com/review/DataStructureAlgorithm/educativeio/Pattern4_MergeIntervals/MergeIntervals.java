package com.review.DataStructureAlgorithm.educativeio.Pattern4_MergeIntervals;
/**
 * Problem Statement #
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
 *
 * Example 1:
 *
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
 * one [1,5].
 */

import java.util.*;

public class MergeIntervals {

    public static void main(String args[]) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,4));
        input.add(new Interval(2,5));
        input.add(new Interval(7,9));

        List<Interval> resultInterval = MergeIntervals.merge(input);

        for(Interval eachInterval: resultInterval ) {
            System.out.println("[" + eachInterval.start + "," + eachInterval.end +"]");
        }
    }

    private static List<Interval> merge(List<Interval> inputInterval) {
        List<Interval> mergedInterval = new ArrayList<Interval>();

        // If interval size is less than 2 return input
        if(inputInterval.size() < 2) {
            return inputInterval;
        }

        // Sort the inputInterval by start of the interval
        Collections.sort(inputInterval, (x,y) -> Integer.compare(x.start, y.start));

        // Iterate over each interval. Find if they overlap - if yes set the correct end
        // if they do no overlap then add the interval to output
        Iterator<Interval> intervalIterator = inputInterval.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if(interval.start <= end) { // There is an overlap so adjust the end
                end = Math.max(interval.end, end);
            } else {
                mergedInterval.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        return mergedInterval;
    }
}
