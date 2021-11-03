package com.review.DataStructureAlgorithm.ElementsOfProgramming.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an array A and a permutation P, apply P to A
 */
public class ApplyPermutation {
    public static void main(String args[]) {
        char[] A = new char[] {'a', 'b', 'c'};
        int[] P = new int[] {3, 2, 1, 0};

//        System.out.println(A);
//        applyPermutation(A, P);
//        System.out.println(A);

        List<List<Character>> result = findAllPermutation(A);
        System.out.println(result);

    }

    // Amazing logic - understand his carefully
    // Every time we swap we want to mark both the index as swapped
    // If we don't want to do this in extra space, then we are marking the permutation index each time to a negative value by subtracting by length
    // Each time 2 swapped index will be marked with negative value. The A array swap only happens once.
    public static void applyPermutation(char[] A, int[] P) {
        for (int i = 0; i < A.length; i ++) {
            int next = i;

            while (P[next] >= 0) {
                // Swap to correct position
                char temp = A[i];
                A[i] = A[P[next]];
                A[P[next]] = temp;

                int temp1 = P[next];
                P[next] = P[next] - P.length;
                next = temp1;
            }
        }
    }


    public static List<List<Character>> findAllPermutation(char[] input) {
        List<List<Character>> allPermutations = new ArrayList<>();

        ArrayList initial = new ArrayList();
        allPermutations.add(initial);

        for (int i = 0; i < input.length; i++) {
            char currentChar = input[i];
            List<List<Character>> resultForCurrentCharacter = new LinkedList<>();

            int currentAllPermutationSize = allPermutations.size();
            for (int j = 0; j < currentAllPermutationSize; j++) {
                List<Character> currentPermutation = allPermutations.get(j);

                for (int k = 0; k < currentPermutation.size()+1; k++) {
                    List<Character> newPerm = new LinkedList<>(currentPermutation);
                    newPerm.add(k, currentChar);
                    resultForCurrentCharacter.add(newPerm);
                }
            }
            allPermutations = resultForCurrentCharacter;
        }

        return allPermutations;
    }
}
