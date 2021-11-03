package com.review.DataStructureAlgorithm.educativeio.DataStructure.Array;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] input = new int[] {1,3,5,4,6,7,8};
        System.out.println(input);
        for(int i : input) {
            System.out.println(i);
        }

        int[] result = removeEven(input);
        System.out.println("****");
        for(int i : result) {
            System.out.println(i);
        }
    }
        public static int[] removeEven(int[] arr) {
            int[] result = Arrays.stream(arr).filter(p -> p % 2 !=  0).toArray();
            // Write - Your - Code- Here
            return result; // change this and return the correct result array
        }
}
