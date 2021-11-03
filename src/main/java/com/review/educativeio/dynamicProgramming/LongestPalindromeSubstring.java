package com.review.educativeio.dynamicProgramming;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class LongestPalindromeSubstring {

    public static void main(String args[]) throws InterruptedException {
        Instant start = java.time.Instant.now();

        System.out.println(longestPalindrome("babad"));

        Instant end = java.time.Instant.now();
        System.out.format("%02d minutes %02d seconds %04d milliseconds \n", java.time.Duration.between(start, end).toMinutes(), java.time.Duration.between(start, end).getSeconds(), java.time.Duration.between(start, end).toMillis());

//        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String n) {
        int maxPalindromeSubstringLength = 1;
        String maxPalindromeSubstring = "";
        boolean isPalindromeStr = false;


        for (int start = 0; start < n.length() -1; start++) {
            for (int end = n.length() - 1; end > start; end --) {
                isPalindromeStr = isPalindrome(n, start, end);

                if (isPalindromeStr && (end-start+1) > maxPalindromeSubstringLength) {
                    maxPalindromeSubstringLength = end - start + 1;
                    maxPalindromeSubstring = n.substring(start, end + 1);
                }
            }
        }

        System.out.println(n);
        System.out.println(maxPalindromeSubstring);
        System.out.println(maxPalindromeSubstringLength);
        return maxPalindromeSubstring;
    }

    private static boolean isPalindrome(String n, int start, int end) {
        while (start <= end) {
            if (n.charAt(start) != n.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
