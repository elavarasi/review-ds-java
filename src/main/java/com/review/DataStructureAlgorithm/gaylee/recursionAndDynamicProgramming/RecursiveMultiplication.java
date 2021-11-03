package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;
/* Do multiplication without using * sign */

public class RecursiveMultiplication {
    public static void main(String args[]) {
        int a = 5;
        int b = 4;
        System.out.println(multiplication(a, b));
    }

    private static int multiplication(int a, int b) {
        int smaller = a < b ? a : b;
        int bigger = a > b ? a : b;

        return doMultication(smaller, bigger);
    }

    private static int doMultication(int smaller, int bigger) {
        if (smaller < 0) {
            return 0;
        }

        if (smaller == 1) {
            return bigger;
        }

        int s = smaller >> 1;
        int halfMultiplicationResult = doMultication(s, bigger);

        if (smaller % 2 == 0) {
            return halfMultiplicationResult + halfMultiplicationResult;
        } else {
            return halfMultiplicationResult + halfMultiplicationResult + bigger;
        }


    }

}
