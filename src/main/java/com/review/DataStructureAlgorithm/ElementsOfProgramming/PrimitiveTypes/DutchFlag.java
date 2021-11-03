package com.review.DataStructureAlgorithm.ElementsOfProgramming.PrimitiveTypes;

import java.util.Arrays;

public class DutchFlag {
    public static void main(String args[]) {
        int[] input = new int[] {2,0,2,1,1,0};
//        System.out.println(Arrays.toString(input));
//        bubblesort(input);
//        System.out.println(Arrays.toString(input));
//
//
//        int[] input2 = new int[] {2, 0, 1};
//        System.out.println(Arrays.toString(input2));
//        selectionsort(input2);
//        System.out.println(Arrays.toString(input2));

        int[] input3 = new int[] {2,0,2,1,1,0};
        System.out.println(Arrays.toString(input3));
        insertionsort(input3);
        System.out.println(Arrays.toString(input3));





    }

    private static void bubblesort(int[] input) {
        // Bubble sort is you bubble up the largest item to the end on each iteration.
        // This algorithm runs in O(n2) and time complexity
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length-1; j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
    }

    private static void selectionsort(int[] input2) {
        // Find the smallest and swap to position 0
        // This algorithm runs in O(n2) time complexity
        for (int i = 0; i < input2.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < input2.length; j++) {
                if (input2[j] < input2[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = input2[i];
            input2[i] = input2[minIndex];
            input2[minIndex] = temp;

        }
    }

    private static void insertionsort(int[] input) {
        // logical division of array to sorted and unsorted. Move from unsorted pile to sorted pile and put it in right position
        // Time complexity is O(n2) but much faster than bubble sort and faster than selection sort.
        for (int i = 1; i < input.length; i++) {
            int val = input[i];
            int hole = i;
            while (hole > 0 && input[hole-1] > val) {
                input[hole] = input[hole-1];
                hole = hole -1;
            }
            input[hole] = val;
        }
    }



}
