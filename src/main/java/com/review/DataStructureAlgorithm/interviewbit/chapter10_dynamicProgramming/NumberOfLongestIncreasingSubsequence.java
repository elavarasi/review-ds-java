/**
 * Incomplete - wrong answer for
 * Input
 * [1,2,3,1,2,3,1,2,3]
 * Output
 * 13
 * Expected
 * 10
 */

package com.review.DataStructureAlgorithm.interviewbit.chapter10_dynamicProgramming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String args[]) {
        int[] num = {1, 3, 5, 4, 7};
        int result = findNumberOfLIS(num);
        System.out.println(result);
    }

    public static int findNumberOfLIS(int[] A) {
        int[] t = new int[A.length];
        int[] count = new int[A.length];
        Arrays.fill(count, 1);

        for (int i=0; i<A.length; i++) {
            t[i] = 1;
        }

        for (int i=1; i<A.length; i++) {
            for (int j = 0; j < i; j++) {
                if(A[i] > A[j]) {
                    if (t[j] >= t[i]) {
                        t[i] = t[j] + 1;
                        count[i] = count[j];
                    } else {
                        count[i] += count[j];
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, t[i]);
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (t[i] == max) {
                result = result + count[i];
            }
        }


        return result;
    }

}
