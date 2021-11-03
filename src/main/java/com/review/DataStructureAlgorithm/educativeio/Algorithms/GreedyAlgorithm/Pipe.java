package com.review.DataStructureAlgorithm.educativeio.Algorithms.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Pipe {
}

class MinimumCost
{

    public static void main(String args[]) {
        int[] pipes = new int[] {4,2,3,6};
        int minCost = minCost(pipes);

        System.out.println(minCost);
    }

    public static int minCost(int[] pipes)
    {
        int cost = 0;

        ArrayList<Integer> currentPipes = new ArrayList<Integer>();

        for (int eachPipe : pipes) {
            currentPipes.add(new Integer(eachPipe));
        }

        Collections.sort(currentPipes);

        while(currentPipes.size() > 2) {
            int pipe1 = currentPipes.get(0);
            int pipe2 = currentPipes.get(1);

            int currentCost = pipe1 + pipe2;
            currentPipes.remove(0);
            currentPipes.remove(0);

            currentPipes.add(currentCost);
            Collections.sort(currentPipes);
            cost = cost + currentCost;
        }
        cost = cost + currentPipes.get(0);
        cost = cost + currentPipes.get(1);

        return cost;
    }
}
