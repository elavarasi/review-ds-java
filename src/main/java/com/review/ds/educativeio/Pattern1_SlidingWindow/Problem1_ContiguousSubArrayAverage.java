/**
 * SLIDING WINDOW PATTERN
Calculate something among all the contiguous subarrays (or sublists) of a given size.
 For example:
 Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

 Visualize each contiguous subarray as a sliding window of ‘5’ elements.
 This means that when we move on to the next subarray, we will slide the window by one element.
 So, to reuse the sum from the previous subarray, we will subtract the element going out of the window and add the element now being included in the sliding window.
 This will save us from going through the whole subarray to find the sum and, as a result, the algorithm complexity will reduce to O(N)O(N).


**/
/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 *
 * Let’s understand this problem with a real input:
 *
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 */

package com.review.ds.educativeio.Pattern1_SlidingWindow;
import java.util.Arrays;

public class Problem1_ContiguousSubArrayAverage {
    public static void main(String args[]) {
        int inputArray[] = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2 };
        int k = 5;

        double[] resultBruteForce = findAverageMeanBruteForce(inputArray, k);
        double[] resultSlidingWindow = findAverageMeanSlidingWindow(inputArray, k);

        System.out.println(Arrays.toString(resultBruteForce));
        System.out.println(Arrays.toString(resultSlidingWindow));
    }

    public static double[] findAverageMeanBruteForce(int[] input, int k) {
        int inputlength = input.length;
        double[] output = new double[inputlength -k + 1];

        for(int i=0; i<= inputlength-k; i++) {
            int startindex = i;
            int endindex = i+k;
            double sum = 0;

            for(int j=startindex; j<endindex; j++) {
                sum += input[j];
            }

            output[i] = sum/k;
        }
        return output;
    }

    public static double[] findAverageMeanSlidingWindow(int[] input, int k) {
        int inputlength = input.length;
        double[] output = new double[inputlength - k + 1];

        int windowstart = 0;
        double windowsum = 0;

        for(int windowend=0; windowend <= inputlength-1; windowend++) {
            windowsum += input[windowend];

            if(windowend == windowstart+k-1) {
                output[windowstart] = windowsum/k;
                windowsum = windowsum - input[windowstart];
                windowstart = windowstart + 1;
            }
        }
        return output;
    }
}
