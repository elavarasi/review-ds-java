package com.review.DataStructureAlgorithm.educativeio.Pattern14_KnapSack;
/*
Given a set of positive numbers, partition the set into two subsets with minimum difference between their subset sums.

Example 1: #
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
 */
public class MinimumSubsetSumDifference {

    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 9};
        int minimumSubsetSumDifference = findMinimumSubsetSumDifference(nums, 0, 0 , 0);
        System.out.println(minimumSubsetSumDifference);
    }

    // Brute force - Time Limit Exceeded. Your submission didn't complete in the allocated time limit.
    private static int findMinimumSubsetSumDifference(int[] nums, int index, int sum1, int sum2) {
        if (index >= nums.length) {
            return Math.abs(sum1 - sum2);
        }

        int subset1MinimumDifference = findMinimumSubsetSumDifference(nums, index+1, sum1 + nums[index], sum2);
        int subset2MinimumDifference = findMinimumSubsetSumDifference(nums, index+1, sum1, sum2 + nums[index]);

        return Math.min(subset1MinimumDifference, subset2MinimumDifference);

    }
}
