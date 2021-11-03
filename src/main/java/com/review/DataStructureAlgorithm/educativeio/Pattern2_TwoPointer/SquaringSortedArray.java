package com.review.DataStructureAlgorithm.educativeio.Pattern2_TwoPointer;

/**
 * Problem Statement #
 * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
 *
 * Example 1:
 *
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 *
 *
 *  note: trick is that we can have negative numbers in the input array,
 */


public class SquaringSortedArray {
    public static void main(String args[]) {
        int[] input = new int[] {-2, -1, 0, 2, 3};
        int[] out = makeSquares(input);
        for (int num : out)
            System.out.print(num + " ");
    }

    public static int[] makeSquares(int[] input) {
        int[] output = new int[input.length];
        int outarrayIndex = input.length-1;

        int left = 0;
        int right = input.length-1;

        while(left <= right) {
            int leftSquare = input[left] * input[left];
            int rightSquare = input[right] * input[right];

            if(leftSquare > rightSquare) {
                output[outarrayIndex--] = leftSquare;
                left++;
            } else {
                output[outarrayIndex--] = rightSquare;
                right --;
            }
        }

        return output;

    }


}


