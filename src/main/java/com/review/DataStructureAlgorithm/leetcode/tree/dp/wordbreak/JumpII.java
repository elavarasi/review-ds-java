package com.review.DataStructureAlgorithm.leetcode.tree.dp.wordbreak;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpII {
    public static void main(String args[]) {

        // int[] nums = new int[] {2, 3, 1, 1, 4};
        int[] nums = new int[] {2, 3, 0, 1, 4};
        //int[] nums = [5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5]; // Time limit will exceed in recursive approach.
        int minJump = minStepsToJumpFromStartToEnd(nums, 0, nums.length-1);
        System.out.println(minJump);

        minJump = minStepsToJumpDPTopDown(nums);
        System.out.println(minJump);

    }

    // Find the min number of steps to jump from start to end
    public static int minStepsToJumpFromStartToEnd(int[] nums, int start, int end) {
        // base condition
        if (start == end) {
            return 0; // no more steps to jump if you are at the end already
        }

        if (nums[start] == 0) {
            return Integer.MAX_VALUE;
        }

        int minSteps = Integer.MAX_VALUE;

        // Recursively calculate
        for (int i = start + 1; i <= end && i <= start + nums[start]; i++) {
            int minStepOfRest = minStepsToJumpFromStartToEnd(nums, i, end);
            if (minStepOfRest != Integer.MAX_VALUE) {
                minSteps = Math.min(minStepOfRest + 1, minSteps);
            }

        }
        return minSteps;
    }


    // DP - top down approach
    public static int minStepsToJumpDPTopDown(int[] nums) {
        if (nums.length == 1 || nums[0] == 0) {
            return 0;
        }

        // memozing to kee track of min jumps to get to a point
        int[] jumps = new int[nums.length];

        jumps[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                // if reachable
                if (i <= j + nums[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[nums.length - 1];
    }
}
