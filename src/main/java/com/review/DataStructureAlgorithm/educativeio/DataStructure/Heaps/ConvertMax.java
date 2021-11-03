package com.review.DataStructureAlgorithm.educativeio.DataStructure.Heaps;

import java.util.Arrays;

public class ConvertMax {

    public static void main(String args[]) {
        int[] heapArray = {9,4,7,1,-2,6,5};
        System.out.println("Max Heap: " + Arrays.toString(heapArray));
        convertMax(heapArray);
        System.out.println("Min Heap: " + Arrays.toString(heapArray));

    }

    private static void convertMax(int[] heapArray) {
        int N = heapArray.length - 1;

        // Go over all root index and heapify
        for (int i = N/2; i >= 0; i--) {
            heapify(heapArray, i);
        }
    }

    private static void heapify(int[] heapArray, int index) {

        int smallest = index;

        while (smallest < heapArray.length / 2) {
            int left = (index * 2) + 1;
            int right = (index * 2) + 2;

            // Find the smallest among root, left and right
            if (left < heapArray.length && heapArray[left] < heapArray[smallest]) {
                smallest = left;
            }

            if (right < heapArray.length && heapArray[right] < heapArray[smallest]) {
                smallest = right;
            }

            // If root is not the smallest then swap to root to the smallest of the 3
            if (smallest != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[smallest];
                heapArray[smallest] = temp;
                index = smallest; // this is important to avoid running in loop
            } else {
                break;
            }
        }
    }
}
