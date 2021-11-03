package com.review.DataStructureAlgorithm.sortingalgorithm;

public class SelectionSort {


    public static void doSelectionSort(int[] input) {


        for (int i = 0; i < input.length; i++) {
            int minNum = 100000;
            int minIndex = i;

            for (int j = i; j < input.length; j++) {
                if (minNum > input[j]) {
                    minNum = input[j];
                    minIndex = j;
                }
            }

            // Swap if min index is not same as left index
            if (i != minIndex) {
                int temp = input[minIndex];
                input[minIndex] = input[i];
                input[i] = temp;
            }

        }
    }


    public static void main(String args[]) {
        int[] input = new int[] {5,4,6,7,8,2,3,4,4};
        doSelectionSort(input);
        for (int eachnumber : input) {
            System.out.println(eachnumber);
        }
    }
}
