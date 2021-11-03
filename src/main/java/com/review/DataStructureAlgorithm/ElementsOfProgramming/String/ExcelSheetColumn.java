package com.review.DataStructureAlgorithm.ElementsOfProgramming.String;

public class ExcelSheetColumn {
    public static void main(String args[]) {
   //     int column  = 40;
     //   int column  = 1;
//        int column  = 27;
//        String result = convertToTitle(column);
//        System.out.println(result);

        String titleToNumber = "AZ";
        int resultValue = titleToNumber(titleToNumber);
        System.out.println(resultValue);
    }

    public static String convertToTitle(int n) {
        char[] charRes = new char[26];
        int i = 0;

        for (char c = 'A'; c <= 'Z'; c++, i++) {
            charRes[i] = c;
        }

        if(n <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            n--;
            int rem = n%26;
            sb.append(charRes[rem]);
            n = n/26;
        }
        return sb.reverse().toString();
    }

    public static int titleToNumber(String col) {
        int ret = 0;
        for (int i = 0; i < col.length(); i++) {
            char c = col.charAt(i);
            ret = ret * 26 + c - 'A' + 1;
        }
        return ret;
    }

}
