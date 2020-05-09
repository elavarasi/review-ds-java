package com.review.ds.educativeio.Pattern2_TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement #
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Example 1:
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * Example 2:
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 *
 *
 */

public class TripletSumToZero {

    public static void main(String args[]) {
        int[] input = new int[] {-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>>  out = searchTriplets(input);
        System.out.println(out.toString());
    }

    public static List<List<Integer>> searchTriplets(int[] inputArr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(inputArr);

        for(int firstPointer = 0; firstPointer < inputArr.length - 1; firstPointer ++) {
            if (firstPointer > 0 && inputArr[firstPointer] == inputArr[firstPointer - 1]) // skip same element to avoid duplicate triplets
                continue;

            int leftPointer = firstPointer + 1;
            int rightPointer = inputArr.length - 1;

            while(leftPointer < rightPointer){
                if(inputArr[firstPointer] + inputArr[leftPointer] + inputArr[rightPointer] == 0) {
                    triplets.add(new ArrayList<>(Arrays.asList(inputArr[firstPointer], inputArr[leftPointer], inputArr[rightPointer])));
                    leftPointer ++;
                    rightPointer --;

                    while (leftPointer < rightPointer && inputArr[leftPointer] == inputArr[leftPointer - 1])
                        leftPointer++; // skip same element to avoid duplicate triplets
                    while (leftPointer < rightPointer && inputArr[rightPointer] == inputArr[rightPointer + 1])
                        rightPointer--; // skip same element to avoid duplicate triplets


                } else if (inputArr[firstPointer] + inputArr[leftPointer] + inputArr[rightPointer] > 0) {
                    rightPointer --;
                } else {
                    leftPointer ++;
                }
            }

        }

        return triplets;
    }

}
