package com.review.ds.educativeio.Pattern1_SlidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 */

public class Problem3_SmallestSubArrayWithGivenSum {
    public static void main(String args[]) {
        int[] inputdata = new int[] {2, 2, 5, 2, 3, 2};
        int s = 7;

        int lengthOfSmalletArrayWithGivenSum = lengthOfSmallestArrayWithGivenSum1(s, inputdata);
        System.out.println(lengthOfSmalletArrayWithGivenSum);
    }


    public static int lengthOfSmallestArrayWithGivenSum(int S, int[] arr) {

        int lengthOfSmalletArrayWithGivenSum = 9999;
        int windowstart = 0;
        int windowsum = arr[0];

        for(int i = 0; i<= arr.length-1; ) {
            if(windowsum >= S) {
                int windowlength = (i - windowstart) + 1;
                lengthOfSmalletArrayWithGivenSum = Math.min(lengthOfSmalletArrayWithGivenSum, windowlength);
                windowsum -= arr[windowstart];
                windowstart ++;
            } else {
                i ++;
                if(i==arr.length) {
                    break;
                }
                windowsum += arr[i];
            }
        }
        return lengthOfSmalletArrayWithGivenSum;
    }

    public static int lengthOfSmallestArrayWithGivenSum1(int S, int[] arr) {

        int lengthOfSmalletArrayWithGivenSum = Integer.MAX_VALUE;
        int windowstart = 0;
        int windowsum = 0;

        for(int windowend = 0; windowend <= arr.length-1; windowend++ ) {
            windowsum += arr[windowend];

            while(windowsum >= S) {
                int windowlength = (windowend - windowstart) + 1;
                lengthOfSmalletArrayWithGivenSum = Math.min(lengthOfSmalletArrayWithGivenSum, windowlength);
                windowsum -= arr[windowstart];
                windowstart++;
            }

        }
        return lengthOfSmalletArrayWithGivenSum;
    }
}
