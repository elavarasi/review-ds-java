package com.review.DataStructureAlgorithm.ElementsOfProgramming.Arrays;

/**
 *
 Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 https://leetcode.com/problems/remove-element/
 */
public class DeleteAKeyFromArray {
    public static void main(String args[]) {
        int[] nums = new int[] {2};
        int val = 3;

        int totalCountAfterRemoval = removeElement(nums, val);
        System.out.println(totalCountAfterRemoval);
    }


    public static int removeElement(int[] nums, int val) {
        // Have index to say where the array item should be.
        // Iterate through the array once, and when we find the val do not increment the counter.
        // So the next element gets written to this position.
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[writeIndex ++] = nums[i];
            }
        }
        return writeIndex;
    }
}
