package com.review.DataStructureAlgorithm.educativeio.Pattern5_CyclicSort;

/*
We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Example 1:

Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
 */

import java.util.ArrayList;
import java.util.List;

public class MissingNumberWithDuplicates {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0;
        while(i < nums.length-1) {
            if(nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j ++) {
            if(nums[j] != j+1) {
                missingNumbers.add(j+1);
            }
        }

        return missingNumbers;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String args[]) {
        int[] input = new int[] {2,3,1,8,2,3,5,1};
        List<Integer> missingNumber = findNumbers(input);
        for (Integer eachMissingNumber: missingNumber) {
            System.out.println(eachMissingNumber);
        }
    }
}
