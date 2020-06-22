package com.review.ds.educativeio.Pattern5_CyclicSort;
/*
Problem Statement #
We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence.
This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and without any extra space.

Example 1:

Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]
 */

public class CyclicSort {

    public static void sort(int[] nums) {
        int i = 0;
        // Iterate the input array and swap if not positioned right
        while (i < nums.length) {
            if (nums[i] != i+1) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String args[]) {
        int[] arr = new int[] {3,1,5,4,2};
        CyclicSort.sort(arr);

        for (int num: arr) {
            System.out.print(num + " ");
        }

        System.out.println("");

        int[] arr1 = new int[] {1, 5, 6, 4, 3, 2};
        CyclicSort.sort(arr1);

        for (int num: arr1) {
            System.out.print(num + " ");
        }

    }
}
