package com.review.DataStructureAlgorithm.educativeio.Arrays;


public class RotateArray {
    public static void main(String args[]) {
        int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int position = 3;
        rotate(input, position);

        for (int eachItem: input) {
            System.out.print(eachItem);
        }
    }

    private static void rotate(int[] input, int position) {
        int currentPosition = 0;
        while (currentPosition < position ) {

            int lastItemToRotate = input[input.length-1];
            int swapElement = input[currentPosition];
            input[currentPosition] = lastItemToRotate;

            for (int i = currentPosition + 1; i < input.length; i++) {
                int temp1 = input[i];
                input[i] = swapElement;
                swapElement = temp1;
            }

            currentPosition ++;
        }
    }
}
