//completed
package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationWithDuplicates {

    public static void main(String args[]) {
        String inputStr = "aaa";

        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map = buildFreqTable(inputStr);


        printPerms(map, "", inputStr.length(), result);
        System.out.println(result);
    }

    public static HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        /* Base Case. Permutation has been completed */
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c: map.keySet()) {
            int count = map.get(c);
            if(count > 0) {
                map.put(c, count-1);
                printPerms(map, prefix + c, remaining-1, result);
                map.put(c, count);
            }
        }
    }


}
