package com.review.ds.educativeio.Pattern2_TwoPointer;

import java.util.HashMap;

/**
 * Problem Statement #
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 */
public class PairWithTargetSum {
    public static void main(String args[]) {
        int[] input = new int[] {1,2,3,4,6};
        int targetSum = 6;
        int[] out = search(input, targetSum);
        System.out.println(out[0] + " " + out[1]);

        int[] input1 = new int[] {2, 5, 9, 11};
        int targetSum1 = 11;
        int[] out1 = search(input1, targetSum1);
        System.out.println(out1[0] + " " + out1[1]);

    }

    // Two pointer approach
    public static int[] search(int[] arr, int targetSum) {
        int pointer1 = 0;
        int pointer2 = arr.length-1;

        while(pointer1 < pointer2) {
            if(arr[pointer1] + arr[pointer2] == targetSum) {
                return new int[]{pointer1, pointer2};
            } else if(arr[pointer1] + arr[pointer2] > targetSum) {
                pointer2 --;
            } else if(arr[pointer1] + arr[pointer2] < targetSum) {
                pointer1 ++ ;
            }
        }
        return new int[] { -1, -1 };
    }

    //Another approach using hash map
    public static int[] search1(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i]))
                return new int[] { nums.get(targetSum - arr[i]), i };
            else
                nums.put(arr[i], i); // put the number and its index in the map
        }
        return new int[] { -1, -1 }; // pair not found
    }

}
