package com.review.DataStructureAlgorithm.educativeio.Pattern2_TwoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subarrays with Product Less than a Target
 * Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.
 *
 * Example 1:
 *
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 */


public class SubarraysWithProductLessThanATarget {

    public static void main(String args[]){
        int[] input = new int[] {2,5,3,10};
        int target = 30;
        List<List<Integer>> subarrays = findSubarrays(input, target);
        System.out.println(subarrays);
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();

        for (int pointer1 = 0; pointer1 < arr.length; pointer1 ++) {
            List<Integer> currentList = new ArrayList<>();
            int currentProduct = 1;

            currentProduct *= arr[pointer1];
            if(currentProduct < target) {
                currentList.add(arr[pointer1]);
                subarrays.add(currentList);
            }

            int pointer2 = pointer1 + 1;
            while(pointer2 < arr.length) {
                List<Integer> newList = new ArrayList<>(currentList);
                currentProduct *= arr[pointer2];

                if(currentProduct < target) {
                    newList.add(arr[pointer2]);
                    subarrays.add(newList);
                } else {
                    break;
                }

                pointer2 ++;
            }
        }

        return subarrays;
    }

}

