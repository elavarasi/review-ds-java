package com.review.DataStructureAlgorithm.educativeio.Pattern11_BinarySearch;

public class BinarySearch {


    public static void main(String args[]) {
        int[] input = new int[] {1, 3, 4, 5, 6, 6};
        int searchValue = 9;
        System.out.println(search(input, searchValue));

    }

    public static int search(int[] input, int searchValue) {
        int start = 0;
        int end = input.length - 1;
        int result = -1;

        boolean isAscending = input[start] < input[end];

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (searchValue == input[mid]) {
                return mid;
            }

            if (searchValue < input[mid]) {
                if (isAscending) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (isAscending) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }


        return result;

    }
}
