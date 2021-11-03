package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;

import java.util.ArrayList;

public class Problem_Parens_AvoidingDuplicatesBeforeCalculatingThem {

    public static void main(String args[]) {
        int n = 3;
        ArrayList<String> result = generateParens(n);

        for (String each : result) {
            System.out.println(each);
        }

    }

    public static ArrayList<String> generateParens(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }

    public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem) {
            return;
        }

        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            // Add left Parent if there are any valid left paren remaining
            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem-1, rightRem, str, count+1);
            }

            // Add Right Parent if expression is valid
            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem-1, str, count+1);
            }


        }

    }

}
