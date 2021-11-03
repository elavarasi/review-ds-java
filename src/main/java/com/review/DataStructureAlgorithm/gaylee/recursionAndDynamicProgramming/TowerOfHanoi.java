package com.review.DataStructureAlgorithm.gaylee.recursionAndDynamicProgramming;

import java.util.Stack;

public class TowerOfHanoi {

    public static void main(String args[]) {
        int n = 3;
        Tower[] towers = new Tower[n];

        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = n-1; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisk(n, towers[2], towers[1]);
        System.out.println(towers[0]);
    }

}

class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int i) {
        disks = new Stack<>();
        index = i;
    }

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() < d) {
            System.out.println("Error placing dish" + d);
        } else {
            disks.push(d);
        }
    }

    public void moveToTop(Tower t) {
        int top = disks.pop();
        t.add(top);
    }

    public void moveDisk(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisk(n-1, buffer, destination);
            moveToTop(destination);
            buffer.moveDisk(n-1, destination, this);
        }
    }

}
