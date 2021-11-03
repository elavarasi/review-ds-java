package com.review.DataStructureAlgorithm.educativeio.Pattern11_BinarySearch;

public class CeilingOfANumber {
    public static void main(String args[]) {
        System.out.println(searchCeilingOfANumber(new int[] {4, 6, 10}, 6));
        System.out.println(searchCeilingOfANumber(new int[] {4, 6, 10, 14, 17, 29}, 18));

    }

    private static int searchCeilingOfANumber(int[] input, int key) {
        if (key > input[input.length-1]) {
            return -1;
        }

        int start = 0; int end = input.length -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < input[mid]) {
                end  = mid - 1;
            } else if (key > input[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return start;
    }

}
