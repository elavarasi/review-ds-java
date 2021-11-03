package com.review.DataStructureAlgorithm.educativeio.Pattern10_Subset;

import java.util.ArrayList;
import java.util.List;

/*
Given a string, find all of its permutations preserving the character sequence but changing case.
Input: "ab7c"
Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                continue;
            }
            List<String> currentLetterPermutation =  new ArrayList<String>(permutations);
            for (String eachEntry : currentLetterPermutation) {
                char[] eachEntryCharacters =  eachEntry.toCharArray();
                if(Character.isLowerCase(eachEntry.charAt(i))) {
                    eachEntryCharacters[i] = Character.toUpperCase(eachEntry.charAt(i));
                } else {
                    eachEntryCharacters[i] = Character.toLowerCase(eachEntry.charAt(i));
                }

                permutations.add(String.valueOf(eachEntryCharacters));
            }
        }

        return permutations;
    }


    public static void main(String[] args) {
        List<String> result1 = LetterCaseStringPermutation.findLetterCaseStringPermutations("C");
        System.out.println(" String permutations are: " + result1);

        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }


}
