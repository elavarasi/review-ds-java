package com.review.DataStructureAlgorithm.educativeio.Algorithms.GreedyAlgorithm.DivideAndConquer;
// Accepted Leetcode : https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/
import java.util.ArrayList;
import java.util.Arrays;

class Merge {

    public static void main(String args[]) {
   //     int[][] input = new int[][] {{1,4}, {3, 6}, {7, 8}};
  //      int[][] input =   new int[][] {{1,4},{0,4}};
 //       int[][] input = new int[][] {{1,4},{2,3}};
//        int[][] input = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] input = new int[][] {{1,3},{2,6},{8,10},{15,18}};
//         int[][] input = new int[][] {{1,4}, {0, 2}, {3, 5}};
        int[][] result = merge(input);
        System.out.println(result);
    }

    public static int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Sort the intervals based on the start
         Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int index = 0;
        int currentLowestStartIndex = 0;
        int currentMaxEndIndex = 0;

        // Merge the intervals
        while (index <= intervals.length - 1) {
            if (index < intervals.length - 1 && intervals[index+1][0] <= intervals[currentMaxEndIndex][1]) {
                currentLowestStartIndex = intervals[index][0] < intervals[currentLowestStartIndex][0] ? index : currentLowestStartIndex;
                currentMaxEndIndex = intervals[index][1] > intervals[currentMaxEndIndex][1] ? index : currentMaxEndIndex;

                currentLowestStartIndex = intervals[index+1][0] < intervals[currentLowestStartIndex][0] ? index+1 : currentLowestStartIndex;
                currentMaxEndIndex = intervals[index+1][1] > intervals[currentMaxEndIndex][1] ? index+1 : currentMaxEndIndex;
                index++;
            } else {
                result.add(new ArrayList());
                result.get(result.size()-1).add(intervals[currentLowestStartIndex][0]);
                result.get(result.size()-1).add(intervals[currentMaxEndIndex][1]);
                index++;
                currentLowestStartIndex = index;
                currentMaxEndIndex = index;
            }
        }

        // Add to Result array
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < 2; j ++) {
                resultArray[i][j] = result.get(i).get(j);
            }
        }

        return resultArray;
    }
}