package com.review.DataStructureAlgorithm.educativeio.Pattern10_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of numbers that might contain duplicates, find all of its distinct subsets.

Example 1:

Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]
Example 2:

Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
 */
public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubset(int[] input) {
        List<List<Integer>> result = new ArrayList<>();

        if (input.length == 0) {
            return result;
        }

        Arrays.sort(input);

        result.add(new ArrayList<Integer>());

        int recentSetSize = 0;

        // Add each input to the current result items and add them to the result.
        for (int i = 0; i < input.length; i++) {

            int n = result.size();
            int j = 0;
            if (i > 0 && input[i] == input[i-1]) {
                j = result.size() - recentSetSize -1;
            }

            for (; j < n; j++) {
                // new subset, from existing result and
                List<Integer> set  = new ArrayList<>(result.get(j));
                set.add(input[i]);
                recentSetSize = set.size();
                result.add(set);
            }

        }
        return result;
    }


    public static void main(String args[]) {
        int[] input = new int[] {1, 5, 5, 3};
        System.out.println(findSubset(input));
    }
}
