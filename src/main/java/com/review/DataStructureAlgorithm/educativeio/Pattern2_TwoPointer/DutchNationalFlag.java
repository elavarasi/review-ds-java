package com.review.DataStructureAlgorithm.educativeio.Pattern2_TwoPointer;

import java.util.Arrays;

/**
 * Dutch National Flag Problem
 * Problem Statement #
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
 *
 * Example 1:
 *
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 */


public class DutchNationalFlag {

    public static void main(String args[]) {
        int[] input = new int[] {1,0,2,1,1};
        int[] out = dutchFlag(input);
        System.out.println(Arrays.toString(out));
    }


    public static int[] dutchFlag(int[] inputArr) {
        int i = 0;
        int low = 0;
        int high = inputArr.length-1;

        while(i <= high) {
            if(inputArr[i] == 0) {
                swap(i, low, inputArr);
                i++;
                low ++;
            } else if(inputArr[i] == 2) {
                swap(i, high, inputArr);
                high --;
            } else { //if value is 1
                i++;
            }
        }

        return inputArr;
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
