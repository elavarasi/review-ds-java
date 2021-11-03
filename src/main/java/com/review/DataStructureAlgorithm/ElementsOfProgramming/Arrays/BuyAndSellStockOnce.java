package com.review.DataStructureAlgorithm.ElementsOfProgramming.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 */

public class BuyAndSellStockOnce {

    public static void main(String args[]) {
        int[] nums = new int[] {7,1,5,3,6,4};

        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int eachPrice : prices) {
            minPrice = Math.min(minPrice, eachPrice);
            maxProfit = Math.max(maxProfit, eachPrice - minPrice);
        }

        return maxProfit;
    }

}
