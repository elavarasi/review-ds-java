package com.review.DataStructureAlgorithm.educativeio.Pattern5_CyclicSort;

import java.util.ArrayList;
import java.util.List;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some duplicates, find all the duplicate numbers without using any extra space.

Example 1:

Input: [3, 4, 4, 5, 5]
Output: [4, 5]
 */
public class FindAllDuplicateNumbers {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;
        // Sort in right index, if index already has same number it is a duplicate
        while (i < nums.length) {
            if(nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != j+1){
                duplicateNumbers.add(nums[j]);
            }
            j++;
        }

        return duplicateNumbers;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicateNumbers.findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicateNumbers.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }
}
