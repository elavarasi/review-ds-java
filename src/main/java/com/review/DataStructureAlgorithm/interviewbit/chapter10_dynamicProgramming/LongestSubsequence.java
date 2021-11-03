/*
Given two strings A and B. Find the longest common sequence ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.

 A = "abbcdgf"
 B = "bbadcgf"

 5
 */

package com.review.DataStructureAlgorithm.interviewbit.chapter10_dynamicProgramming;

public class LongestSubsequence {
    public static void main(String args[]) {
        String A = "bebdeeedaddecebbbbbabebedc";
        String B = "abaaddaabbedeedeacbcdcaaed";
        System.out.println(solve(A, B));

    }


    public static int solve(String A, String B) {
        int [][] dp = new int[A.length()+1][B.length()+1];
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= A.length();  i++) {
            for (int j = 0; j <= B.length(); j ++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[A.length()][B.length()];
    }

}
