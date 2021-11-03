package com.review.DataStructureAlgorithm.ElementsOfProgramming.String;

public class TestPalindromecity {

    public static void main(String[] args) {
//        String input = "Ela is a good girl";
     //   String input = "1Elale1666";
//        String input =  "A man, a plan, a canal: Panama";
//        String input =  ".,";
          String input =  "0P";
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String s) {
        int forwardPointer = 0;
        int backwardPointer = s.length()-1;
        boolean isPalindrome = true;

        while (forwardPointer < backwardPointer && forwardPointer <= s.length()-1 && backwardPointer >= 0) {
            while(!(s.charAt(forwardPointer) >= '0' && s.charAt(forwardPointer) <= '9') && !(s.charAt(forwardPointer) >= 'a' && s.charAt(forwardPointer) <= 'z') && !(s.charAt(forwardPointer) >= 'A' && s.charAt(forwardPointer) <= 'Z')) {
                if (forwardPointer < backwardPointer) {
                    forwardPointer ++;
                } else {
//                    isPalindrome = false;
                    break;
                }

            }

            while ((!(s.charAt(backwardPointer) >= '0' && s.charAt(backwardPointer) <= '9') && !(s.charAt(backwardPointer) >= 'a' && s.charAt(backwardPointer) <= 'z') && !(s.charAt(backwardPointer) >= 'A' && s.charAt(backwardPointer) <= 'Z'))) {
                if (backwardPointer > forwardPointer) {
                    backwardPointer --;
                } else {
//                    isPalindrome = false;
                    break;
                }

            }

            System.out.println(s.charAt(forwardPointer));
            System.out.println(s.charAt(backwardPointer));

            if (Character.toLowerCase(s.charAt(forwardPointer)) != Character.toLowerCase(s.charAt(backwardPointer))) {
                isPalindrome = false;
                break;
            }

            forwardPointer ++;
            backwardPointer --;
        }

        return isPalindrome;
    }
}
