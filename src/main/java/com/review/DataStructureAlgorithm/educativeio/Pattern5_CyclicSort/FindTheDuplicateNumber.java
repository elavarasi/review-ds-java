package com.review.DataStructureAlgorithm.educativeio.Pattern5_CyclicSort;
/*
We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.

Example 1:

Input: [1, 4, 4, 3, 2]
Output: 4
 */

public class FindTheDuplicateNumber {

    public static int findNumber(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if (nums[i] != i+1) {
                if (nums[i] != nums[nums[i]-1]) {
                    swap(nums, i, nums[i]-1);
                } else {
                    return nums[i]; // return the first duplicate as there is only one duplicate
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindTheDuplicateNumber.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindTheDuplicateNumber.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindTheDuplicateNumber.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
