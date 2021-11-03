package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.Arrays;

public class StringProduct {
    public static void main(String args[]) {
        String num1 = "3456";
        String num2 = "5433";

        StringBuilder str1 = new StringBuilder(num1);
//        str1.reverse();
        System.out.println(str1);


        StringBuilder str2 = new StringBuilder(num2);
//        str2.reverse();
        System.out.println(str2);

        int result[] = new int[str1.length() + str2.length()];

//        for (int i = 0; i < str1.length(); i++) {
//            for (int j = 0; j < str2.length(); j++) {
//                int product = str1.charAt(i) * str2.charAt(j);
//                result[j] = result[j] + product;
//                result [j+1] = result [j] / 10;
//                result [j] = result[j] % 10;
//            }
//        }

        for (int i = str1.length()-1; i >= 0; i --) {
            for (int j = str2.length()-1; j >= 0; j --) {
                int num_1 = str1.charAt(i) - '0';
                int num_2 = str2.charAt(j) - '0';

                int product = (num_1) * (num_2);
                result[i+j+1] = result[i+j+1] + product;
                result [i+j] = result [i+j+1] / 10;
                result [i+j+1] = result[i+j+1] % 10;
            }
        }

        for (int eachNum : result) {
            System.out.print(eachNum);
        }
    }

}
