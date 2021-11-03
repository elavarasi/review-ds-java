package com.review.DataStructureAlgorithm.educativeio.Pattern10_Subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an expression containing digits and operations (+, -, *),
find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
 */
public class PossibleWaysToEvaluateExpression {
    static Map<String, List<Integer>> map = new HashMap<>();

    public static void main (String args[]) {
        String inputStr = "2*3-4-5";
        List<Integer> result = findPossibleEval(inputStr);
        System.out.println(result);

        String inputStr1 = "2*3-4-5";
        List<Integer> result1 = findPossibleEvalMemoized(inputStr1);
        System.out.println(result1);
    }

    private static List<Integer> findPossibleEval(String inputStr) {

        List<Integer> result = new ArrayList<>();
        if (!inputStr.contains("+") && ! inputStr.contains("-") && ! inputStr.contains("*")) {
            result.add(Integer.valueOf(inputStr));
            return result;
        }
        // For each * - + we will break left and right and find possible eval on each side. Then do the operation
        for (int i = 0; i <= inputStr.length()-1; i++) {
            if (inputStr.charAt(i) == '+' || inputStr.charAt(i) == '*' || inputStr.charAt(i) == '-') {
                List<Integer> leftCombinations = findPossibleEval(inputStr.substring(0, i));
                List<Integer> rightCombinations = findPossibleEval(inputStr.substring(i + 1));

                for (Integer eachLeft : leftCombinations) {
                    for (Integer eachRight : rightCombinations) {
                        if (inputStr.charAt(i) == '+') {
                           result.add(new Integer(eachLeft + eachRight));
                        }

                        if (inputStr.charAt(i) == '-') {
                            result.add(new Integer(eachLeft - eachRight));
                        }

                        if (inputStr.charAt(i) == '*') {
                            result.add(new Integer(eachLeft * eachRight));
                        }
                    }
                }
            }
        }

        return result;
    }

    private static List<Integer> findPossibleEvalMemoized(String inputStr) {
        if (map.containsKey(inputStr)) {
            return map.get(inputStr);

        }
        List<Integer> result = new ArrayList<>();
        if (!inputStr.contains("+") && ! inputStr.contains("-") && ! inputStr.contains("*")) {
            result.add(Integer.valueOf(inputStr));
            return result;
        }
        // For each * - + we will break left and right and find possible eval on each side. Then do the operation
        for (int i = 0; i <= inputStr.length()-1; i++) {
            if (inputStr.charAt(i) == '+' || inputStr.charAt(i) == '*' || inputStr.charAt(i) == '-') {
                List<Integer> leftCombinations = findPossibleEval(inputStr.substring(0, i));
                List<Integer> rightCombinations = findPossibleEval(inputStr.substring(i + 1));

                for (Integer eachLeft : leftCombinations) {
                    for (Integer eachRight : rightCombinations) {
                        if (inputStr.charAt(i) == '+') {
                            result.add(new Integer(eachLeft + eachRight));
                        }

                        if (inputStr.charAt(i) == '-') {
                            result.add(new Integer(eachLeft - eachRight));
                        }

                        if (inputStr.charAt(i) == '*') {
                            result.add(new Integer(eachLeft * eachRight));
                        }
                    }
                }
            }
        }
        map.put(inputStr, result);
        return result;
    }
}
