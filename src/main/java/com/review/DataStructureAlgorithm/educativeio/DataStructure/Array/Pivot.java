package com.review.DataStructureAlgorithm.educativeio.DataStructure.Array;

public class Pivot {
    public static void main(String args[]) {
        int[] input = {7,9,4,0,1,5,4,8,6,4,3};

        for(int i : input) {
            System.out.print(i + "\t");
        }
        System.out.print("\n");

        sortByPivot(input);

        for(int i : input) {
            System.out.print(i + "\t");
        }

        System.out.print("\n");

        // Sort By Recursion
//        int[] input1 = {7,9,0,1,5,8,6,3};
//        sortByRecursion(input, 0, input1.length-1);
//        for(int i : input1) {
//            System.out.print(i + "\t");
//        }
    }

    public static void sortByPivot(int[] input) {
        int lowerBound = 0, middleBound = 0, upperBound = input.length-1;

        while (middleBound < upperBound) {
            if (input[middleBound] < 4) {
                int temp = input[lowerBound];
                input[lowerBound] = input[middleBound];
                input[middleBound] = temp;
                middleBound++;
                lowerBound++;
            } else if (input[middleBound] == 4) {
                middleBound++;
            } else {
                int temp = input[middleBound];
                input[middleBound] = input[upperBound];
                input[upperBound] = temp;
                upperBound--;
            }
        }

    }
}
