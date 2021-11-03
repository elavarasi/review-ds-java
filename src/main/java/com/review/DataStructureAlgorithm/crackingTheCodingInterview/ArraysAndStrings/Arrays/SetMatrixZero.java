package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.Arrays;
/**
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

import java.util.SortedSet;
import java.util.TreeSet;

public class SetMatrixZero {

    public static void main(String args[]){
        int[][] input = {{0, 1, 2, 0},{3, 4, 5, 2},{1, 3, 1, 5}};
        setZeroes(input);

        printArray(input);
    }

    public static void setZeroes(int[][] matrix) {
        // Find the rows and columns that needs change
        SortedSet rows = new TreeSet();
        SortedSet columns = new TreeSet();

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        // Iterate and find rows and columns that need to be set to 0
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        // Iterate over the matrix and set corresponding rows and columns to 0
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printArray(int[][] input) {
        int rowLength = input.length;
        int columnLength = input[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                System.out.print(input[i][j]);
            }
            System.out.print("\n");
        }
    }
}
