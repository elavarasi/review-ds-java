//completed
package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithoutDuplicates {

    public static void main(String args[]) {
        String inputStr = "abc";

        List<String> allPerms = getPerms(inputStr);
        System.out.println(allPerms);
    }

    private static List<String> getPerms(String inputStr) {
        if (inputStr == null) {
            return null;
        }

        List<String> perms = new ArrayList<>();

        if (inputStr.length() == 1) {
            perms.add(inputStr);
            return perms;
        }

        // Get first character of the string
        char firstChar = inputStr.charAt(0);
        //Get rest of the string
        String restOfTheString = inputStr.substring(1,inputStr.length());
        List<String> permsOfRest = getPerms(restOfTheString);

        for (String eachPerm: permsOfRest) {
            for (int i = 0; i <= eachPerm.length(); i++) {
                perms.add(insertAtIndex(i, firstChar, eachPerm));
            }
        }

        return perms;
    }

    public static String insertAtIndex(int index, char firstChar, String otherChar) {
        String start = otherChar.substring(0, index);
        String end = otherChar.substring(index);
        return start + firstChar + end;
    }
}
