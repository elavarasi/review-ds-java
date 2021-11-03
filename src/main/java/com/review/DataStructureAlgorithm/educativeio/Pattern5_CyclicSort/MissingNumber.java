package com.review.DataStructureAlgorithm.educativeio.Pattern5_CyclicSort;
/*
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Example 1:

Input: [4, 0, 3, 1]
Output: 2
Example 2:

Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7
 */

public class MissingNumber {

    public static int findMissingNumber(int[] input) {


        int i = 0;
        // Iterate over each number in input and swap if it is not equal to index
        while (i < input.length) {
            if (input[i] < input.length && input[i] != i) {
                swap(input, i, input[i]);
            } else {
                i ++;
            }
        }

        for (int j = 0; j < input.length; j++) {
            if (input[j] != j) {
                return j;

            }
        }

        return input.length;
    }

    public static void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }


    public static void main(String args[]) {
        int[] input = new int[] {4,0,3,1};
        int missingNumber = findMissingNumber(input);
        System.out.println(missingNumber);
    }

}
