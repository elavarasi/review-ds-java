package com.review.ds.educativeio.Pattern1_SlidingWindow;

/**
 * Problem Statement #
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 *
 * Example 1:
 *
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * Example 2:
 *
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
public class Problem8_LongestSubstringWithOnesAfterReplacement
{

    public static void main(String args[]) {
        int[] input = new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k = 2;
        int length = longestSubstringWithOnesAfterReplacement(input, k);
        System.out.println(length);

        int[] input1 = new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k1 = 3;
        int length1 = longestSubstringWithOnesAfterReplacement(input1, k1);
        System.out.println(length1);
    }

    public static int longestSubstringWithOnesAfterReplacement(int[] input, int k) {
        int lengthOfLongestSubstring = 0;
        int windowStart = 0;
        int countOfOnesInWindow = 0;

        for(int windowEnd = 0; windowEnd < input.length; windowEnd++ ){
            if(input[windowEnd] == 1) {
                countOfOnesInWindow ++;
            }

            if(windowEnd - windowStart + 1 - countOfOnesInWindow > k) {
                if(input[windowStart] ==  1) {
                    countOfOnesInWindow --;
                }
                windowStart ++;
            }

            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart + 1);

        }

        return lengthOfLongestSubstring;
    }

}
