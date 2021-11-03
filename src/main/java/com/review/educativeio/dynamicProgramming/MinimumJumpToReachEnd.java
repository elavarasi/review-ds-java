package com.review.educativeio.dynamicProgramming;

public class MinimumJumpToReachEnd {
    public static void main(String[] args) {
        MinimumJumpToReachEnd aj = new MinimumJumpToReachEnd();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }

    public int countMinJumps(int[] jumps) {
        Integer[] minStepToReach = new Integer[jumps.length];

        for (int i = 0; i < minStepToReach.length; i++) {
            minStepToReach[i] = Integer.MAX_VALUE;;
        }
        minStepToReach[0] = 0;

        for (int i = 0; i < jumps.length-1; i++) {
            int noOfPositionsCanCover = jumps[i];
            for (int j = i + 1; j <= i + noOfPositionsCanCover && j < jumps.length; j++) {
                minStepToReach[j] = Math.min(minStepToReach[i] + 1,  minStepToReach[j]);
            }
        }

        if (minStepToReach[jumps.length-1] != Integer.MAX_VALUE) {
            return minStepToReach[jumps.length-1];
        }

        return -1;
    }
}
