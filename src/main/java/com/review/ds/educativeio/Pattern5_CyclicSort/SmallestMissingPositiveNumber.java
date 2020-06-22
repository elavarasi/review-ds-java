package com.review.ds.educativeio.Pattern5_CyclicSort;
/*
Find the Smallest Missing Positive Number (medium) #
Given an unsorted array containing numbers, find the smallest missing positive number in it.

Example 1:

Input: [-3, 1, 5, 4, 2]
Output: 3
Explanation: The smallest missing positive number is '3'
Example 2:

Input: [3, -2, 0, 1, 2]
Output: 4
 */
public class SmallestMissingPositiveNumber {
    public static int findNumber(int[] nums) {

        // Place items in right positions, ignoring out of index items
        int i = 0;
        while(i<nums.length) {
            if(nums[i] != i+1 && nums[i] != nums[i]+1  && nums[i] > 0 && nums [i] < nums.length) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        // Iterate over the sorted numbers and find first missing positive number
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1 && nums[j] > -1) {
                return j+1;
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(SmallestMissingPositiveNumber.findNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(SmallestMissingPositiveNumber.findNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(SmallestMissingPositiveNumber.findNumber(new int[] { 3, 2, 5, 1 }));
    }

}
