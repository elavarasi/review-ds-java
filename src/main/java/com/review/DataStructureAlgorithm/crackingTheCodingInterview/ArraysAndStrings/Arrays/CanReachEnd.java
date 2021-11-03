package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.Arrays;

import java.util.Stack;

/**
 * Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 */
public class CanReachEnd {
    public static void main(String args[]) {
//        int[] input = new int[] {2,3,1,1,4};
        Stack<Integer> stk = new Stack<Integer>();
        //Corner cases
        int[] input = new int[] {1};

        boolean canreachend = canReachEnd(input);
        System.out.println(canreachend);
    }


    public static boolean canReachEnd(int[] input) {
        boolean canreachend = false;
        int maxCurrentReact = 0;
        for (int currentIndex = 0; currentIndex < input.length; currentIndex ++) {
            if (currentIndex <= maxCurrentReact) {
                maxCurrentReact = Math.max(maxCurrentReact, currentIndex + input[currentIndex]);
            } else {
                break;
            }

            if (currentIndex == input.length-1 || maxCurrentReact == input.length-1) {
                canreachend = true;
                break;
            }
        }
        return canreachend;
    }
}
