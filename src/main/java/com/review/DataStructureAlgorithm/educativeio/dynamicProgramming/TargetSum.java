package com.review.DataStructureAlgorithm.educativeio.dynamicProgramming;

class TargetSum {

    public int findTargetSubsets(int[] num, int s) {
        // TODO: Write your code here
        int[][] dp = new int[num.length-1][s+1];

        return countTargetSumSubsets(num, 0, 0, s);
        // return -1;
    }

    public int countTargetSumSubsets(int[] num, int index, int sum, int targetSum) {
        if (index == num.length) {
            return sum == targetSum ? 1 : 0;
        }

        int positiveSum = countTargetSumSubsets(num, index+1, sum + (num[index]), targetSum);
        int negativeSum = countTargetSumSubsets(num, index+1, sum + (- num[index]), targetSum);

        return positiveSum + negativeSum;
    }


    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (S > sum || -S < -sum) return 0;

        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;

        for (int num: nums) {
            int[] next = new int[2 * sum + 1];
            for (int i = 0; i < dp.length; i++) {
                // Only branch out from reachable target sums
                if (dp[i] == 0) continue;
                next[i + num] += dp[i];
                next[i - num] += dp[i];
            }
            dp = next;
        }

        return dp[sum + S];
    }


    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSumWays(num, 1));
//        num = new int[]{1, 2, 7, 1};
//        System.out.println(ts.findTargetSubsets(num, 9));
    }
}