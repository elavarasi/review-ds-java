package com.review.DataStructureAlgorithm.ElementsOfProgramming.PrimitiveTypes;

/**
 * Count no of 1's in a binary word
 * If it is odd the parity is 1. If it is even then parity is 0.
 */
public class Parity {

    public static void main(String args[]) {

        long binaryWord = 10010010;

        short parity = parity(binaryWord);

        System.out.println(parity);
    }

    public static short parity(long binaryWord) {
        short result = 0;

        while (binaryWord != 0) {
            result ^= (binaryWord & 1);
            binaryWord >>>= 1;
        }

        return result;
    }

}
