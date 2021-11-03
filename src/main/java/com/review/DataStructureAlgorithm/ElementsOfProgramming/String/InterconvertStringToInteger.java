package com.review.DataStructureAlgorithm.ElementsOfProgramming.String;
/*
Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
 */
public class InterconvertStringToInteger {
    public static void main(String args[]) {
//        String str1 = "-415";
        String str1 = "-91283472332";
        int result = myAtoi(str1);
        System.out.println(result);
    }

    public static int myAtoi(String s) {
        int sign = 1;
        int result = 0;

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                continue;
            }

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            // Please note carefully how we are getting the value below
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {

                if (result > Integer.MAX_VALUE / 10 ||
                        (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = result * 10 + s.charAt(i) - '0';
            }
        }

        return result * sign ;
    }

}
