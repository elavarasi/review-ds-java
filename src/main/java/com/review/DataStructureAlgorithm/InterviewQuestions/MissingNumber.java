package com.review.DataStructureAlgorithm.InterviewQuestions;

public class MissingNumber {

    public static void main(String args[]) {
        String str = "0123456789101213";
        int N = 13;

//        String str = "01235";
//        int N = 5;
        
        int missingNumber = findMissingNumber(str, N);
        System.out.println("Missing Number is " + missingNumber);
    }

    public static int findMissingNumber(String str, int n) {
        int expectedSum = 0;
        int actualSum = 0;

        int expectedStringLength = 0;
        int inputStringLength = str.length();

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            expectedStringLength++;
            strBuilder.append(i);
        }

        for (int i = 0; i < strBuilder.toString().length(); i++) {
            expectedSum = expectedSum + Character.getNumericValue(strBuilder.toString().charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            actualSum = actualSum + Character.getNumericValue(str.charAt(i));
        }

        System.out.println(expectedSum);
        System.out.println(actualSum);

        System.out.println(expectedStringLength);
        System.out.println(inputStringLength);
        int lengthDiff = expectedStringLength - inputStringLength;
        int valueDiff = expectedSum - actualSum;
        int result = 0;

        if (lengthDiff == 1) {
            result =  expectedSum - actualSum;
        } else {
            for (int i = 10; i <= 20; i++) {
                if (getSum(i) == valueDiff) {
                    result = i;
                    break;
                }


            }
        }
        return result;
    }

    public static int getSum(int i) {
        int number = i;
        int sum = 0;
        int quotient = number;
        while (quotient > 0) {
            sum = sum + quotient % 10;
            quotient = quotient / 10;
        }
        return sum;
    }
}
