package com.review.DataStructureAlgorithm.ElementsOfProgramming.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class DeleteDuplicatesFromSortedArray {
    public static void main(String args[]) {
        int[] nums = new int[] {2, 4, 5, 5, 6, 7, 7, 1};
        int val = 3;

        int totalCountAfterRemoval = removeDuplicates(nums);
        System.out.println(totalCountAfterRemoval);
    }

    public static int removeDuplicates(int[] nums) {
        int writeIndex = 0;
        int previousVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != previousVal) {
                previousVal = nums[i];
                nums[writeIndex ++] = nums[i];
            }
        }
        return  writeIndex;
    }


    // Have an index to know where to write the next element.
    // If current element is a duplicate do not write else write it in current position and increment counter.
    public static int removeDuplicatesBookApproach(int[] nums) {
        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[writeIndex ++] = nums[i];
            }
        }
        return  writeIndex;
    }
}
