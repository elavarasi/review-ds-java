package com.review.DataStructureAlgorithm.interviewbit.chapter10_dynamicProgramming;
/**
 * Implement wildcard pattern matching with support for ‘?’ and ‘*’ for strings A and B.
 *
 * ’?’ : Matches any single character.
 * ‘*’ : Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Input Format:
 *
 * The first argument of input contains a string A.
 * The second argument of input contains a string B.
 * Output Format:
 *
 * Return 0 or 1:
 *     => 0 : If the patterns do not match.
 *     => 1 : If the patterns match.
 */

import java.util.Arrays;

public class RegularExpressionMatch {

    public static void main(String args[]) {
//        String str = "baaabab";
//        String pattern = "ba*ab";

        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String pattern = "*b";
        System.out.println(isMatch(str, pattern));
    }


    public static int isMatch(final String str, final String pattern) {
        if (str.length() == 0 && pattern.length() == 0) {
            return 0;
        }

        boolean[][] dp = new boolean[str.length()+1][pattern.length()+1];

        // Initialize dp table to false
        for (int i = 0; i <= str.length(); i++) {
            Arrays.fill(dp[i], false);// This fills all columns in each row
        }

        // Empty pattern will match with empty string
        dp[0][0] = true;

        // * and empty string will be a match
        for (int j = 1; j <= pattern.length(); j++) {
            if(pattern.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }


        //fill in the table bottom up fashion
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                // if pattern has '*' 2 cases
                // (a) we ignore the character on the pattern and move on to next character
                // (b) '*' matches with ith character in the input
                if(pattern.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp [i-1][j];
                }

                // Current characters are considered as matching in two cases
                // (a) current character of pattern is '?'
                // (b) current character of string matches current character of pattern
                else if (pattern.charAt(j-1) == '?' || str.charAt(i-1) == pattern.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }

                else {
                    dp[i][j] = false;
                }
            }
        }

//        return dp[str.length()][pattern.length()];

        if (dp[str.length()][pattern.length()] == true) {
            return 1;
        } else {
            return 0;
        }
    }
}
