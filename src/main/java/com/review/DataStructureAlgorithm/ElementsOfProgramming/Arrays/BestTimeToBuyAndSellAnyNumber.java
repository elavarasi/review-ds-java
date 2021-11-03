package com.review.DataStructureAlgorithm.ElementsOfProgramming.Arrays;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellAnyNumber {

    public static void main(String args[]) {
//        int[] nums = new int[] {7,1,5,3,6,4};
//        int[] nums = new int[] {1, 2, 3, 4, 5};
        int[] nums = new int[] {2,1,4,5,2,9,7};

        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);
    }

    // Approach, find local min and go as far as we get profit.
    // If the the profit drops then take profit until previous and current price is new local min
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int localMinPrice = Integer.MAX_VALUE;
        int[] profitSoFar = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            localMinPrice = Math.min(localMinPrice, prices[i]);
            profitSoFar[i] = prices[i] - localMinPrice;

            if (i != 0 && profitSoFar[i] < profitSoFar[i-1]) {
                totalProfit += profitSoFar[i-1];
                localMinPrice = prices[i];
                profitSoFar[i] = prices[i] - localMinPrice;
            }

            if (i == prices.length-1) {
                totalProfit += profitSoFar[i];
            }

        }
        return totalProfit;
    }
}
