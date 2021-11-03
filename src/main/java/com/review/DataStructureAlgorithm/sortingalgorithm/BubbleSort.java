package com.review.DataStructureAlgorithm.sortingalgorithm;

public class BubbleSort {

    private static void doBubbleSort(int[] input) {
        int n = input.length;
        for (int i=0; i < n-1; i++) {
            for (int j=0; j < n-i-1; j++) {
                if(input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] input = new int[] {5,4,6,7,8,2,3,4,4};
        doBubbleSort(input);
        for (int eachnumber : input) {
            System.out.println(eachnumber);
        }
    }
}
