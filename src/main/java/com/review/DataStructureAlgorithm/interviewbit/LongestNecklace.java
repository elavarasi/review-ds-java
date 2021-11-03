package com.review.DataStructureAlgorithm.interviewbit;

public class LongestNecklace {
    public static void main(String args[]) {
        int[] nextBeads = new int[] {5, 4, 0, 3, 1, 6, 2};
        int longestNecklace = getLengthOfLongestNecklace(nextBeads);
        System.out.println(longestNecklace);
    }

    public static int getLengthOfLongestNecklace(int[] nextBeads) {
        if (nextBeads.length == 0) {
            return 0;
        }

        if (nextBeads.length == 1) {
            return 1;
        }
        int maxLength = 1;

        for (int i = 0; i < nextBeads.length; i++) {
            int currentNecklaceLength = 1;
            int startBead = nextBeads[i];
            int nextBead = nextBeads[startBead];
            while (startBead != nextBead) {
                currentNecklaceLength ++;
                nextBead = nextBeads[nextBead];
            }
            maxLength = Math.max(currentNecklaceLength, maxLength);
        }
        return maxLength;
    }
}
