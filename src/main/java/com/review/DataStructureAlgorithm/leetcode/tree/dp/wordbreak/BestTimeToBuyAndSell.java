package com.review.DataStructureAlgorithm.leetcode.tree.dp.wordbreak;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSell {
    public static void main(String args[]) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(100);
        A.add(180);
        A.add(260);
        A.add(310);
        A.add(40);
        A.add(535);
        A.add(695);

        int profit = maxProfit(A);

        System.out.println(profit);

    }


    public static int maxProfit(final List<Integer> A) {
        return findMaxProfit(A, 0, A.size()-1);
    }

    private static int findMaxProfit(List<Integer> input, int start, int end) {
        // Can't sell and no profit
        if (end <= start) {
            return 0;
        }

        int profit = 0;

        for (int i = start; i <= end; i++) {

            for (int j = i + 1; j <= end; j++) {

                // For each stock price, find the profit if sold on each of the subsequent days

                if (input.get(i) < input.get(j)) {
                    int currentProfit = (input.get(j) - input.get(i)) + findMaxProfit(input, start, i-1) + findMaxProfit(input, j + 1, end);

                    profit = Math.max(currentProfit, profit);

                }
            }
        }

        return profit;
    }

}
