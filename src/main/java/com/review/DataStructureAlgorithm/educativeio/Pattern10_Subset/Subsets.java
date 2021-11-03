package com.review.DataStructureAlgorithm.educativeio.Pattern10_Subset;

import java.util.ArrayList;
import java.util.List;
/*
Given a set with distinct elements, find all of its distinct subsets.

Example 1:

Input: [1, 3]
Output: [], [1], [3], [1,3]
Example 2:

Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Subsets {

    public static List<List<Integer>> findSubset(int[] input) {

        List<List<Integer>> result = new ArrayList<>();

        if (input.length == 0) {
         return result;
        }

        result.add(new ArrayList<Integer>());

        // Add each input to the current result items and add them to the result.
        for (int i = 0; i < input.length; i++) {
            int n = result.size();

            for (int j = 0; j < n; j++) {
                // new subset, from existing result and
                List<Integer> set  = new ArrayList<>(result.get(j));
                set.add(input[i]);
                result.add(set);
            }

        }
        return result;
    }

    public static void main(String args[]) {
        int[] input = new int[] {1, 5, 3};
        System.out.println(findSubset(input));
    }
}
