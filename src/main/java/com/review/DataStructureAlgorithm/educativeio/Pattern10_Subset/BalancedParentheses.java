package com.review.DataStructureAlgorithm.educativeio.Pattern10_Subset;

import java.util.ArrayList;
import java.util.List;

public class BalancedParentheses {

    public static void main(String[] args) {
        List<String> result = BalancedParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = BalancedParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }

    private static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        char[] parenthesesString = new char[2*num];
        generateValidParenthesesRecursively(num, 0, 0, parenthesesString, 0, result);
        return result;
    }

    private static void generateValidParenthesesRecursively(int num, int openCount, int closeCount, char[] parenthesesString, int index, List<String> result) {

        if (openCount == num && closeCount == num) {
            result.add(new String(parenthesesString));
        } else {
            if (openCount < num) {
                parenthesesString[index] = '(';
                generateValidParenthesesRecursively(num, openCount + 1, closeCount, parenthesesString, index + 1, result);
            }
            if (openCount > closeCount) {
                parenthesesString[index] = ')';
                generateValidParenthesesRecursively(num, openCount, closeCount + 1, parenthesesString, index+1, result);
            }
        }
    }

}
