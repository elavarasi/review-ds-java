package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;

public class Coins {


    public static void main(String args[]) {
        int n = 100;
        int[] denominators = {25, 10};

        int ways = findWaysToMake(n, denominators, 0);
        System.out.println(ways);
    }

    public static int findWaysToMake(int amount, int[] denominators, int index) {

        if (amount == 0){
            return 1;
        }
        // Base condition last denom
        if (index >= denominators.length ) {
            return 0;
        }

        int ways = 0;
        for (int i = 0; denominators[index] * i <= amount; i++) {
            int remainingAmount = amount - i * denominators[index];
            ways += findWaysToMake(remainingAmount, denominators, index+1);
        }

        return ways;
    }


}
