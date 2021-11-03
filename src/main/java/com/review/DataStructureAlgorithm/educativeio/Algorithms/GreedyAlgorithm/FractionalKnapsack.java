package com.review.DataStructureAlgorithm.educativeio.Algorithms.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String args[]) {
        double maxValue = getMaxValue(new double[] {2, 1, 6, 0.5, 0.25, 7}, new double[] {50, 70, 100, 50, 30, 99}, 10);
        System.out.println(maxValue);
    }

    public static double getMaxValue(double[] w, double[] v, double c) {

        ItemValue[] items = new ItemValue[w.length];

        for (int i = 0; i < w.length; i++) {
            items[i] = new ItemValue(w[i], v[i], i);
        }

        Arrays.sort(items, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });
        double totalValue = 0;
        for (ItemValue i: items) // iterator to traverse items list
        {
            double currWeight = (double) i.w;
            double currValue = (double) i.v;

            if (c - currWeight >= 0) // this item can be picked as whole
            {
                c = c - currWeight;
                totalValue += currValue;

                // uncomment the following line to see the step by step working of this function
                // System.out.println("c, v, t = " + c + ", " + currValue + ", " + totalValue);
            } else // item can't be picked as whole
            {
                double fraction = ((double) c / (double) currWeight); // only a fraction of it can be obtained!
                totalValue += (currValue * fraction);
                c = (double)(c - (currWeight * fraction));

                // uncomment the following line to see the step by step working of this function
                System.out.println("c, v, t = " + c + ", " + currValue + ", " + totalValue + "\n");
                break;
            }
        }
        return totalValue;

    }
}


class ItemValue {
    Double cost;
    double w, v, i;

    ItemValue(double w, double v, int i) {
        this.w = w;
        this.v = v;
        this.i = i;
        cost = v/w;
    }

}