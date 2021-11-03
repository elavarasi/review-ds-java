package com.review.DataStructureAlgorithm.educativeio.Pattern10_Subset;
/*
Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:
 */

import java.util.LinkedList;
import java.util.List;

public class Permutations {


    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            List<List<Integer>> resultForCurrentNumber = new LinkedList<>();

            for (int j = 0; j < result.size(); j++) {

                List<Integer> currentPermutation = result.get(j);

                for (int k = 0; k < currentPermutation.size() + 1 ; k++) {
                    List<Integer> eachPermutation = new LinkedList<Integer>(currentPermutation);
                    eachPermutation.add(k, currentNumber);
                    resultForCurrentNumber.add(eachPermutation);
                }


            }
            result = resultForCurrentNumber;
        }

        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }

}
