package com.review.DataStructureAlgorithm.crackingTheCodingInterview.ArraysAndStrings.Arrays;

public class StringCompression {
    // Ela's approach
    public static void main(String args[]) {
//        char[] input = new char[] {'a','a','b','b','c','c','c'};
        char[] input = new char[] {'a'};
        System.out.println(compress(input));
        System.out.println(input);
        System.out.println("******");

        char[] input1 = new char[] {'a'};
        System.out.println(compress1(input1));
        System.out.println(input1);

    }

    public static int compress(char[] chars) {
        StringBuilder builder = new StringBuilder();
        int consequtiveCount = 0;

        for (int i = 0; i < chars.length; i++) {
            consequtiveCount ++;
            if (i + 1 >= chars.length || chars[i+1] != chars[i]) {
                builder.append(chars[i]);
                if(consequtiveCount > 1){
                    builder.append(consequtiveCount);
                }
                consequtiveCount = 0;
            }
        }

         char[] finalChar = builder.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < finalChar.length) {
                chars[i] = finalChar[i];
            }

        }

        System.out.println(chars);
        System.out.println(finalChar);
        return chars.length;
        }


    public static int compress1(char[] chars) {

        if(chars.length == 0 || chars.length == 1) return chars.length;

        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<chars.length - 1; i++) {
            if(chars[i] == chars[i+1]) cnt += 1;
            else
            {
                sb.append(chars[i]);
                if(cnt > 1) sb.append(cnt);
                cnt = 1;
            }
        }

        sb.append(chars[chars.length - 1]);
        if(cnt>1) sb.append(cnt);

        char[] newChar = sb.toString().toCharArray();
        for(int i = 0; i<newChar.length; i++)
            chars[i] = newChar[i];

        System.out.println(chars);
        System.out.println(newChar);
        return newChar.length;
    }


}
