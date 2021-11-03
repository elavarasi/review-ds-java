package com.review.DataStructureAlgorithm.interviewbit.chapter10_dynamicProgramming;

public class LongestPalindromeSequence {

        public static void main(String args[]) {
            String A = "bebeeed";
            System.out.println(solve(A, A));

        }

        public static int solve(String A, String B) {
            int maxLengthOfPalindromeSubstring = 0;
            StringBuilder currentSubstring = new StringBuilder();

            int[][] dp = new int[A.length() + 1][B.length() + 1];
            if (A.length() == 0 || B.length() == 0) {
                return 0;
            }

            for (int i = 0; i <= A.length(); i++) {
                for (int j = 0; j <= B.length(); j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;

                        currentSubstring.append(A.charAt(i - 1));
                        if (isPalindrome(currentSubstring.toString())) {
                            maxLengthOfPalindromeSubstring = Math.max(maxLengthOfPalindromeSubstring, currentSubstring.length());
                        }

                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }

                }
            }
            return maxLengthOfPalindromeSubstring;
        }

        public static boolean isPalindrome(String A) {
            int i = 0;
            int j = A.length()-1;
            boolean isPalindrome = true;

            while (i < j) {
                if (A.charAt(i) != A.charAt(j)) {
                    isPalindrome = false;
                    break;
                }

                i++;
                j--;
            }

            return isPalindrome;

        }
}
