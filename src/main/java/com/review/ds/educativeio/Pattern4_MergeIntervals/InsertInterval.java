    package com.review.ds.educativeio.Pattern4_MergeIntervals;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    /*
    Problem Statement #
    Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

    Example 1:

    Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
    Output: [[1,3], [4,7], [8,12]]
    Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].

     */
    public class InsertInterval {
        public static void main(String args[]) {
            List<Interval> input = new ArrayList<Interval>();
            input.add(new Interval(1,3));
            input.add(new Interval(5,7));
            input.add(new Interval(8,12));

           for (Interval interval: InsertInterval.insert(input, new Interval(4,7))) {
                System.out.println("start:end" + " " + interval.start + " : " + interval.end);
            }
        }


        public static List<Interval>  insert(List<Interval> input, Interval newInterval) {
            List<Interval> result = new ArrayList<Interval>();

            if(input == null || input.isEmpty()) {
                return Arrays.asList(newInterval);
            }

            int i = 0;

            while(i<input.size() && input.get(i).end < newInterval.start ) {
                result.add(input.get(i));
                i++;
            }

            while(i<input.size() && input.get(i).start < newInterval.end) {
                newInterval.start = Math.min(input.get(i).start, newInterval.start);
                newInterval.end = Math.max(input.get(i).end, newInterval.end);
                i++;
            }
            result.add(newInterval);

            while(i<input.size()) {
                result.add(input.get(i++));
            }

            return result;
        }
    }
