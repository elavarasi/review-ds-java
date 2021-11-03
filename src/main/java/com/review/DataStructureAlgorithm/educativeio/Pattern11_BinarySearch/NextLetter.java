package com.review.DataStructureAlgorithm.educativeio.Pattern11_BinarySearch;

/**
 * Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.
 *
 * Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter. This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.
 *
 * Write a function to return the next letter of the given ‘key’.
 */
public class NextLetter {

    public static void main(String args[]) {
        char[] input = new char[] {'a', 'c', 'f', 'h'};
        char key = 'b';
        System.out.println(findNextLetter(input, key));
    }

    private static char findNextLetter(char[] input, char key) {
        int n = input.length;
        int start = 0;
        int end = n -1;

        // Since we need to consider it to be circular
        if (key > input[n-1] || key < input[start]) {
            return input[0];
        }

        while (start <= end) {
            int mid = start + ( end - start) / 2;
            if (key < input[mid]) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }

        return input[start % n];
    }

}
