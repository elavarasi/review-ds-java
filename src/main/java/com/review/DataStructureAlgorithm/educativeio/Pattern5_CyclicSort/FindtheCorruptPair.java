package com.review.DataStructureAlgorithm.educativeio.Pattern5_CyclicSort;
/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

Example 1:

Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.
 */
public class FindtheCorruptPair {
    public static int[] findNumbers(int[] nums) {
        // Sort the array so that numbers are in right index
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        for(int j=0; j<nums.length; j++) {
            if(nums[j] != j+1){
                return new int[] {nums[j], j+1};
            }
        }
        return new int[] { -1, -1 };
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = FindtheCorruptPair.findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindtheCorruptPair.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }

}
