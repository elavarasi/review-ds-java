package com.review.DataStructureAlgorithm.sortingalgorithm;

public class InsertionSort1 {

    public static void doInsertionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            // check with previous element if it is smaller than previous. If yes swap until right position to fit
            int j = i;
            while (j > 0 && input[j] < input[j-1]) {
                int temp = input[j-1];
                input[j-1] = input[j];
                input[j] = temp;
                j--;
            }
        }
    }

    public static void main(String args[]) {
        int[] input = new int[] {5,4,6,7,8,2,3,4,4};
        doInsertionSort(input);
        for (int eachnumber : input) {
            System.out.println(eachnumber);
        }
    }
}
