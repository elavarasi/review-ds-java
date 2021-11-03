package com.review.DataStructureAlgorithm.educativeio.DataStructure.Heaps;
// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/

public class KLargestElements {

    public static void main(String args[]) {
        int[] input = new int[] {4, 5, 2, 1,  2, 6, 8};
        int k = 1;
        int kthLargestNumber = findKth(input, k);
        System.out.println(kthLargestNumber);
    }

    public static int findKth(int[] input, int k) {
        int[] kLargeNumbers = new int[k];

        // Heapify k times and each time get the largest number each time.
        int arraySize = input.length;
        for (int i = 0; i < k; i++) {
            heapifyAllRootNodes(input, arraySize);
            kLargeNumbers[i] = input[0];
            input[0] = input[arraySize-1];
            arraySize --;
        }
        return kLargeNumbers[k-1];
    }

    // Heapify all root nodes
    public static void heapifyAllRootNodes(int[] input, int arraySize) {
        for (int i = (arraySize/2)-1; i >=0; i--) {
            heapify(input, i, arraySize);
        }
    }

    // Heapify the given index
    public static void heapify(int[] input, int index, int length) {
        int largest = index;

        // For every root node check its children and if children are larger swap them
        while (index < length/2) {
            // Get left and right child node index
            int left = (index * 2) + 1;
            int right = (index * 2) + 2;

            if (left < length && input[largest] < input[left]) {
                largest = left;
            }
            if (right < length && input[largest] < input [right]) {
                largest = right;
            }

            // Swap if root is not the largest
            if (largest != index) {
                int temp = input[index];
                input[index] = input[largest];
                input[largest] = temp;
                index = largest;
            } else {
                break;
            }
        }
    }
}
