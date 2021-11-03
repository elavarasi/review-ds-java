// https://www.educative.io/module/lesson/dynamic-programming-patterns/NEY8yQJ9yx8

package com.review.educativeio.dynamicProgramming;

import org.junit.Test;

public class LongestPalindromeSubsequence {
    @Test
    public static void main(String[] args) {
//        System.out.println(findLPSLength("abdbca"));
//        System.out.println(findLPSLength("cddpd"));
//        System.out.println(findLPSLength("pqr"));

        int result = findLPSLengthBrute("abdbca", "", 0);
        int result1 = findLPSLengthBrute("cddpd", "", 0);
        int result2 = findLPSLengthBrute("pqr", "", 0);

//        System.out.println(result);
//        System.out.println(result1);
//        System.out.println(result2);

//        int result3 = findLPSLengthTopDownApproach("abdbca", 0, 5);
//        int result4 = findLPSLengthTopDownApproach("cddpd", 0, 4);
//        int result5 = findLPSLengthTopDownApproach("pqr", 0, 2);

//        int result3 = findLPSLengthTopDownApproachDP("abdbca", 0, 5, new Integer[6][6]);
//        int result4 = findLPSLengthTopDownApproachDP("cddpd", 0, 4, new Integer[6][6]);
//        int result5 = findLPSLengthTopDownApproachDP("pqr", 0, 2, new Integer[6][6]);

        int result3 = findLPSLengthBottomUp("abdbca");
        int result4 = findLPSLengthBottomUp("cddpd");
        int result5 = findLPSLengthBottomUp("pqr");

        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);



    }

    // Ela's approach. This won't work
    public static int findLPSLength(String n) {
        int startPointer = 0;
        int endPointer = n.length()-1;
        int counter = 0;

        while (startPointer <= endPointer) {
            if (startPointer == endPointer) {
                counter += 1;
                return counter;
            } else if (n.charAt(startPointer) == n.charAt(endPointer)) {
                startPointer++;
                endPointer--;
                counter += 2;
            } else if (n.charAt(startPointer) != n.charAt(endPointer)) {
             endPointer--;
            }
        }

        return counter;
    }

    // Find all substring
    public static int findLPSLengthBrute(String n, String currentString, int index) {
        if (index >= n.length()) {
            if (isPalindrome(currentString)) {
                return currentString.length();
            } else {
                return Integer.MIN_VALUE;
            }
        }

        int lengthIncludingCurrentCharacter = findLPSLengthBrute(n, currentString + n.charAt(index), index+1);
        int lengthWithoutCurrentCharacter = findLPSLengthBrute(n, currentString, index+1);

        return Math.max(lengthIncludingCurrentCharacter, lengthWithoutCurrentCharacter);

    }

    public static int findLPSLengthTopDownApproach(String n, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return 1;
        }

        if (startIndex > endIndex) {
            return 0;
        }

        if (n.charAt(startIndex) == n.charAt(endIndex)) {
            return 2 + findLPSLengthTopDownApproach(n, startIndex + 1, endIndex - 1);
        }

        int count1 = findLPSLengthTopDownApproach(n, startIndex + 1, endIndex);
        int count2 = findLPSLengthTopDownApproach(n, startIndex, endIndex - 1);

        return Math.max(count1, count2);
    }


    public static int findLPSLengthTopDownApproachDP(String n, int startIndex, int endIndex, Integer[][] dp) {
        if (startIndex == endIndex) {
            return 1;
        }

        if (startIndex > endIndex) {
            return 0;
        }

        if (dp[startIndex][endIndex] == null) {
            if (n.charAt(startIndex) == n.charAt(endIndex)) {
                dp[startIndex][endIndex] =  2 + findLPSLengthTopDownApproach(n, startIndex + 1, endIndex - 1);
            } else {
                int count1 = findLPSLengthTopDownApproach(n, startIndex + 1, endIndex);
                int count2 = findLPSLengthTopDownApproach(n, startIndex, endIndex - 1);
                dp[startIndex][endIndex] = Math.max(count1, count2);
            }
        }

        return dp[startIndex][endIndex];
    }

    public static int findLPSLengthBottomUp(String n) {
        int dp[][] = new int[n.length()][n.length()];

        // Starting and ending on same index will have length of 1
        for (int i = 0; i < n.length(); i++) {
            dp[i][i] = 1;
        }

        for (int startIndex = n.length() - 2; startIndex >=0 ; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < n.length(); endIndex ++) {
                if (n.charAt(startIndex) == n.charAt(endIndex)) {
                    dp[startIndex][endIndex] =  2 + dp[startIndex+1][endIndex-1];
                } else {
                    dp[startIndex][endIndex] =  Math.max(dp[startIndex+1][endIndex], dp[startIndex][endIndex-1]);
                }

            }
        }

        return dp[0][n.length()-1];
    }




    public static boolean isPalindrome(String n) {
        int startPointer = 0;
        int endPointer = n.length()-1;

        while (startPointer < endPointer) {
            if (n.charAt(startPointer) == n.charAt(endPointer)) {
                startPointer++;
                endPointer--;
            } else {
                return false;
            }
        }
        return true;
    }


}
