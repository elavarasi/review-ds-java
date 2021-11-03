package com.review.DataStructureAlgorithm.interviewbit.chapter10_dynamicProgramming;

public class EditDistance {

    public static void main(String args[]) {
        String A = "MARCH";
        String B = "CART";
        System.out.println(minDistance(A,B));
    }


    public static int minDistance(String A, String B) {

        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0) {
                    dp[i][j] = j;
                } else if (j ==0) {
                    dp[i][j] = i;
                } else if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + min(
                            dp[i][j-1],  // Addition
                            dp[i-1][j-1], // replace
                            dp[i-1][j]);  // remove


                }
            }
        }

        return dp[m][n];

    }


    public static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }
}
