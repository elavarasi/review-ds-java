package com.review.DataStructureAlgorithm.educativeio.Pattern2_TwoPointer;

/**
 * Comparing Strings containing Backspaces (medium) #
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 * Example 1:
 *
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * Example 2:
 *
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * Example 3:
 *
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 */
public class Problem2 {

    public static void main(String args[]) {
        String inputStr1 = "xp#";
        String inputStr2 = "xyz##";

        boolean same = compare(inputStr1, inputStr2);
        System.out.println(same);
    }

    public static boolean compare(String str1, String str2) {
        boolean same = false;
        char[] inputStr1 = str1.toCharArray();
        char[] inputStr2 = str2.toCharArray();

        int p1 = inputStr1.length - 1;
        int p2 = inputStr2.length - 1;

        while(!(p1 < 0) && !(p2 < 0)) {
            if((inputStr1[p1] == inputStr2[p2]) && !(inputStr1[p1]== '#' && inputStr2[p2]=='#')) {
                if (p1==0 && p2==0) {
                    same = true;
                }
                p1--;
                p2--;
            } else if (inputStr1[p1] == '#' || inputStr2[p2] == '#') {

                if(inputStr1[p1] == '#') {
                    int p1Counter = 0;
                    while(inputStr1[p1] == '#' && !(p1<0)) {
                        p1Counter ++;
                        p1 --;
                    }
                    p1 = p1 - p1Counter;
                }

                if(inputStr2[p2] == '#') {
                    int p2Counter = 0;
                    while(inputStr2[p2] == '#' && !(p2<0)) {
                        p2Counter ++;
                        p2 --;
                    }
                    p2 = p2-p2Counter;
                }

            } else {
                break; //not same;
            }
        }

        return same;
    }
}
