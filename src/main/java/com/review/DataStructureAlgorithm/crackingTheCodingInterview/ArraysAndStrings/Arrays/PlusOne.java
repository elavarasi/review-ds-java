package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

    public static void main(String args[]) {
//        int[] digits = {6, 7, 8};
        int[] digits = {9, 9};

        for (int eachElement : digits) {
            System.out.print(eachElement);
        }
        int[] result = plusOne(digits);

        System.out.println();
        for (int eachElement : result) {
            System.out.print(eachElement);
        }

        List<Integer> al = new ArrayList<>();
        al.add(9);
        al.add(9);
        System.out.println(plusOne(al));

    }


    // Ela's approach
    // Keep in mind if most significant bit has a carry over then the size of result increases by 1
    public static int[] plusOne(int[] digits) {
        int carryOn = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            // Add 1 if units place
            if (i == digits.length - 1) {
               sum = digits[i] + carryOn + 1;
            } else {
                sum = digits[i] + carryOn;
            }

            if (sum - 10 >= 0) {
                digits[i] = sum - 10;
                carryOn = sum % 9;
                if (i == 0) {
                    // Most significant bit
                    int[] result = new int[digits.length+1];
                    result[0] = carryOn;
                    for (int j = 0; j < digits.length; j++) {
                        result[j+1] = digits[j];
                    }
                    return result;
                }
            } else {
                digits[i] = sum;
                break;
            }
        }
        return digits;
    }


    public static List<Integer> plusOne(List<Integer> A) {
        int n = A.size() - 1;

        A.set(n, A.get(n) + 1);

        for (int i = n; i > 0 && A.get(i) == 10; i --) {
            A.set(i, 0);
            A.set(i - 1, A.get(i-1) + 1);
        }

        if (A.get(0) == 10) {
            // Need additional digit as the most significant digit has a carry-out
            A.set(0, 0);
            A.add(0, 1);
        }

        return A;
    }
}
