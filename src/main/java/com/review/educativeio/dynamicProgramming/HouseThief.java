package com.review.educativeio.dynamicProgramming;

class HouseThief {

    public int findMaxSteal(int[] wealth) {
        return findMaxStealFromCurrentHome(wealth, 0);
    }

    public static int findMaxStealFromCurrentHome(int[] wealth, int currentIndex) {

        if (currentIndex >= wealth.length) {
            return 0;
        }

        int maxWealthFromCurrentIndex = Integer.MIN_VALUE;
//
//        for (int i = currentIndex; i < wealth.length; i++) {
            int maxWealthIncludingCurrentIndex = wealth[currentIndex] + findMaxStealFromCurrentHome(wealth, currentIndex + 2);
            int maxWealthExcludingCurrentIndex = findMaxStealFromCurrentHome(wealth, currentIndex + 1);
            maxWealthFromCurrentIndex = Math.max(maxWealthIncludingCurrentIndex, maxWealthExcludingCurrentIndex);
//        }

        return maxWealthFromCurrentIndex;

    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
//        wealth = new int[]{2, 10, 14, 8, 1};
//        System.out.println(ht.findMaxSteal(wealth));
    }
}


