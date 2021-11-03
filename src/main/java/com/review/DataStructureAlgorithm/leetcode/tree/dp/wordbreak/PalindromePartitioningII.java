package com.review.DataStructureAlgorithm.leetcode.tree.dp.wordbreak;

public class PalindromePartitioningII {
    public static void main(String args[]) {
        String input = "abcde";
        System.out.println(minPalPartition(input));
    }

    private static int minPalPartition(String input) {

        if (input.length() == 0) {
            return -1;
        }
        if (input.length() == 1) {
            return 0;
        }

        int minCut = Integer.MAX_VALUE;
        for (int i = 0; i < input.length(); i++) {
            String firstSubString = input.substring(0, i);
            if(isPalindrome(firstSubString)) {
                int minCutOfRest = minPalPartition(input.substring(i, input.length()));
                minCut = Math.min(minCut, minCutOfRest + 1);
            }
        }
        return minCut;
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;
        boolean isPalindrome = true;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }
        return isPalindrome;
    }
}


