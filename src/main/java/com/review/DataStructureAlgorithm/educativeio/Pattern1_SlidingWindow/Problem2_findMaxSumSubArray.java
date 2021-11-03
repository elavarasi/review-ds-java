package com.review.DataStructureAlgorithm.educativeio.Pattern1_SlidingWindow;
/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 */

public class Problem2_findMaxSumSubArray {

    public static void main(String args[]) {
        int inputArray[] = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2 };
        int k = 5;

        int result = findMaxSumSubArray(k, inputArray);
        System.out.println(result);

    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int windowStart = 0;
        int windowSum = 0;

        for(int windowEnd=windowStart; windowEnd <= arr.length-1; windowEnd++) {
            windowSum += arr[windowEnd];

            if(windowEnd == windowStart + k - 1 ) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }
}
