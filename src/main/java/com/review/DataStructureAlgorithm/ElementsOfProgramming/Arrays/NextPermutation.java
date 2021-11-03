package com.review.DataStructureAlgorithm.ElementsOfProgramming.Arrays;

/** Page 75 in Element of programming book
 * https://leetcode.com/problems/next-permutation/submissions/
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 * Solution:
 * Step1: Start from the right and find k such that p[k] < p[k+1] and entries after index k
 * appear in decreasing order.
 * Step 2: Find the smallest p[l] such that p[l] > p[k]
 * Step 3: Swap p[l] and p[k]. Note sequence after k remains in decreasing order.
 * Step 4: Reverse the sequence after position k
 *
 */
public class NextPermutation {
    public static void main(String args[]) {
//        int[] A = new int[] {3, 2, 1, 0};
        int[] A = new int[] {1, 3, 2};

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
        nextPermutation(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println();
            System.out.print(A[i]);
        }
    }

    public static void nextPermutation(int[] nums) {

        if (nums.length == 1 || nums.length == 0) {
            return;
        }

        // start from end and which the first index which is not in descending order
        int k = nums.length -1;
        while (k > 0 && nums[k-1] >= nums[k]) {
            k --;
        }

        if (k == 0) {
            // Now sort from k to end in ascending order
            int l = nums.length-1;
            for (int i = 0; i < nums.length/2; i++)  {
                int temp = nums[i];
                nums[i] = nums[l - i];
                nums[l - i] = temp;
            }
            return;
        }

        // k - 1 is the index that needs to be swapped as until k to end it is in descending order
        // find the index of the element that is greater than k-1
        int j = nums.length-1;
        while (j >= k) {
            if (nums[j] > nums[k-1]) {
                int temp = nums[k-1];
                nums[k-1] = nums[j];
                nums[j] = temp;
                break;
            }
            j--;
        }

        // Now sort from k to end in ascending order
        int i = nums.length-1;
        while (k < i) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            k ++;
            i --;
        }

    }
}
