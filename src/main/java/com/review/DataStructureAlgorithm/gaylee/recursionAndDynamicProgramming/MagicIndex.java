package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;
/* Find the magic index in a sorted distinct array. Magic index is when index and array value are same */
public class MagicIndex {

    public static void main(String args[]) {
        int[] arr = new int[] {-40, -20, -1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println(magicindex(arr));
    }

    private static int magicindex(int[] arr) {
        return findmagicindex(arr, 0, arr.length-1);
    }

    private static int findmagicindex(int[] arr, int start, int end) {
        if(end < start) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] < mid) {
            return findmagicindex(arr, mid + 1, end);
        } else {
            return findmagicindex(arr, start, mid -1);
        }


    }


}
