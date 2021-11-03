package com.review.DataStructureAlgorithm.interviewbit.chapter10_dynamicProgramming;

import java.util.Arrays;
import java.util.List;


public class LongestIncreasingSubsequence {
    //[ 14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78 ]
    public static void main(String args[]) {
        Integer[] a = {14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78};
        List<Integer> A = Arrays.asList(a);
        int result = lis(A);
        System.out.println(result);
    }


    public static int lis(final List<Integer> A) {

        int[] t = new int[A.size()];

        for (int i=0; i<A.size(); i++) {
            t[i] = 1;
        }

        for (int i=1; i<A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(A.get(i) > A.get(j)) {
                    t[i] = Math.max(t[i], t[j]+1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, t[i]);
        }
        return max;

    }
}
