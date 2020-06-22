package com.review.ds.educativeio.Pattern5_CyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Find the First K Missing Positive Numbers (hard) #
Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

Example 1:

Input: [3, -1, 4, 5, 5], k=3
Output: [1, 2, 6]
Explanation: The smallest missing positive numbers are 1, 2 and 6.
Example 2:

Input: [2, 3, 4], k=3
Output: [1, 5, 6]
Explanation: The smallest missing positive numbers are 1, 5 and 6.
 */
public class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        //First we sort the array if numbers are not in right index and not out of array size
        int i = 0;
        while (i<nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        List<Integer> missingNumber = new ArrayList<>();
        Set<Integer> extraNumber = new HashSet<>();
        // Got over the sorted array add missing numbers until K. Also record extra Numbers to skip later
        for (i = 0; i < nums.length && missingNumber.size() < k; i++) {
            if (nums[i] != i+1 ) {
                missingNumber.add(i+1);
                extraNumber.add(nums[i]);
            }
        }

        // Add remaining missing numbers
        for(i = 1; missingNumber.size() < k; i++ ) {
            int candidateNumber = i + nums.length;
            if (!extraNumber.contains(candidateNumber)) {
                missingNumber.add(candidateNumber);
            }
        }

        return missingNumber;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }

}
