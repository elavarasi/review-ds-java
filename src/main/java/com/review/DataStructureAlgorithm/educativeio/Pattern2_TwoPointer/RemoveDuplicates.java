package com.review.DataStructureAlgorithm.educativeio.Pattern2_TwoPointer;

public class RemoveDuplicates {
    public static void main(String args[]) {
        int[] input = new int[] {2,3,3,3,6,9,9};
        int out = removeDuplicates(input);
        System.out.println(out);
    }

    public static int removeDuplicates(int[] arr) {
        int nextNonDuplicate = 1;

        for(int i=0; i< arr.length; i++) {
            if(arr[nextNonDuplicate-1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static int removeDuplicates1(int[] arr) {
        int nextNonDuplicate = 1;

        for(int i=0; i< arr.length; i++) {
            if(arr[nextNonDuplicate-1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }


}
