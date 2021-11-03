package com.review.DataStructureAlgorithm.educativeio.Pattern14_KnapSack;
//https://leetcode.com/problems/partition-equal-subset-sum/
// educative.io
import java.util.ArrayList;

public class EqualSubsetSumPartitions {
    public static void main(String args[]) {

//        int[] nums = {1, 5, 11, 5};
//        boolean canBePartitioned = canPartitionBruteForce(nums);
//        System.out.println(canBePartitioned);
//
//        int[] nums1 = {1, 1, 1, 1};
//        boolean canBePartitioned1 = canPartitionBruteForce(nums1);
//        System.out.println(canBePartitioned1);
//
//        int[] nums2 = {1, 2, 5};
//        boolean canBePartitioned2 = canPartitionBruteForce(nums2);
//        System.out.println(canBePartitioned2);
//
//        int[] nums3 = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
//        // This will fail on brute force approach. Need a different approach
//        boolean canBePartitioned3 = canPartitionBruteForce(nums3);
//        System.out.println(canBePartitioned3);

//        System.out.println("********");
//
//        int[] nums4 = {1, 5, 11, 5};
//        System.out.println(canPartitionRecursionApproach(nums4));
//
//        System.out.println("********");

//        int[] nums5 = {1, 5, 11, 5};
        int[] nums5 = {1, 2, 3, 5};
        System.out.println(canPartitionTopDownMemoization(nums5));

        System.out.println("********");

    }

    // Ela attempt brute force - Memory limit will be exceeded in this approach - leet code
    public static boolean canPartitionBruteForce(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int total = 0;
        int subtotal = 0;

        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
        }

        if (total % 2 == 1) {
            return false;
        } else {
            subtotal = total / 2;
        }

        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> finalSubset = new ArrayList<ArrayList<Integer>>();

        allSubsets.add(new ArrayList());

        // Iterate over all nums items and find all subsets
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            // Add current num to each item in allSubset to create current subset
            int subsetSize = allSubsets.size(); // Make sure there is no simultaneous same time modification of arraylist (that is why we get the size first) instead of iterating array list
            for (int j = 0; j < subsetSize; j++) {
                ArrayList<Integer> currentList = new ArrayList<>(allSubsets.get(j));

                int eachSubsetTotal = 0;

                currentList.add(currentNum);

                for (Integer eachCurrentList : currentList) {
                    eachSubsetTotal = eachSubsetTotal + eachCurrentList;
                }

                if(eachSubsetTotal == subtotal) {
                    finalSubset.add(currentList);
                }
                allSubsets.add(currentList);
            }
        }

        if ( finalSubset.size() >= 2) {
            return true;
        } else {
            return false;
        }
    }

    //**************************************************

    // Recursion approach - this approach has time limit exceeded issue
    public static boolean canPartitionRecursionApproach(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 0) {
            return canPartitionRecursion(sum/2, nums, 0);
        } else {
            return false;
        }
    }

    public static boolean  canPartitionRecursion(int sum, int[] nums, int index) {
        // Base condition
        if (sum == 0) {
            return true;
        }

        if (index >= nums.length) {
            return false;
        }

        if (nums[index] <= sum) {
            if (canPartitionRecursion(sum - nums[index], nums, index +1)) {
                return true;
            }
        }

        return canPartitionRecursion(sum, nums, index + 1 );
    }

    //**************************************************

    // Top Down DP with Memoization - Accepted approach
    public static boolean canPartitionTopDownMemoization(int[] nums) {
        int indexLength = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 0) {
            sum = sum / 2;
        } else {
            return false;
        }

        Boolean dp[][] = new Boolean[indexLength][sum+1]; //note this is sum + 1 //Also note we can start with null for all - that is why Boolean
        return canPartitionToDownMemoizationApproach(sum, dp, nums, 0);
    }

    public static boolean canPartitionToDownMemoizationApproach(int sum, Boolean dp[][], int[] nums, int index) {
        // Base condition
        if (sum == 0) {
            return true;
        }

        if (index >= nums.length || nums.length == 0) {
            return false;
        }

        // If we have not processed a similar problem
        if (dp[index][sum] == null) {
            // recursive call after choosing the number at the currentIndex
            // if the number at currentIndex exceeds the sum, we shouldn't process this
            if (nums[index] <= sum) {
                if(canPartitionToDownMemoizationApproach(sum - nums[index], dp, nums, index+1)) {
                    dp[index][sum] = true;
                    return true;
                }
            }

            // recursive call after excluding the number at the currentIndex
            dp[index][sum] = canPartitionToDownMemoizationApproach(sum, dp, nums, index+1);
            return dp[index][sum];
        }

        return dp[index][sum];
    }




    // Bottom Up DP
}
