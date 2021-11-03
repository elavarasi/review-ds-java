package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.Arrays;

public class RotateMatrix {
    public static void main(String args[]) {
        int[][] input1 = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        char[][] input2 = {{'a', 'b', 'c', 'd'},{'e', 'f', 'g', 'h'},{'i', 'j', 'k', 'l'},{'m', 'n', 'o', 'p'}};

//        rotate(input);
//        printArray(input);

        rotateInPlace(input2);
        printArray(input2);
    }

    public static void rotate(int[][] matrix) {
        int[][] output = new int [matrix.length][matrix.length];

        for (int column = 0; column < matrix.length; column ++) {
            int outputRow = column;
            int outputColumn = 0;
            for (int row = matrix.length -1; row >=0; row --) {
                output[outputRow][outputColumn++] = matrix[row][column];
            }
        }
        printArray1(output);
        matrix = output;
    }


    public static boolean rotateInPlace(char[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                char top = matrix[first][i];

                matrix[first][i] = matrix[last-offset][first];

                matrix[last-offset][first] = matrix[last][last-offset];

                matrix[last][last-offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }

        return true;
    }


    public static void printArray(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void printArray1(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.print("\n");
        }
    }
}
