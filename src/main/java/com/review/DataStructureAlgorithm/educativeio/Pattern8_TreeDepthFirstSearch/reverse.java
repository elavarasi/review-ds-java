package com.review.DataStructureAlgorithm.educativeio.Pattern8_TreeDepthFirstSearch;

public class reverse {

        public static String reverseWords(String s) {
            int leftPointer = 0;
            int rightPointer = s.length()-1;

            int leftWordStart = 0;
            int leftWordEnd = 0;
            int rightWordStart = 0;
            int rightWordEnd = 0;


            while (leftPointer < rightPointer ) {

                char temp = s.charAt(leftPointer);


//                char temp = s.charAt(leftPointer);
//                s..setCharAt(leftPointer, s.charAt(rightPointer));
//                s.setCharAt(rightPointer, temp);
//
//                s.replace()s.charAt(leftPointer) = 's';
//                s.charAt(leftPointer) = s.charAt(rightPointer);
//                s.charAt(rightPointer) = temp;


                leftPointer ++;
                rightPointer --;
            }

            System.out.println(s);
            return s;
        }

        public static void main(String args[]) {
            reverseWords("Ela is studying");
        }
}
