package com.review.javaReview.Collections;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Tree {
    public static void main(String args[]) {
        TreeSet tr = new TreeSet();
        tr.add('a');
        tr.add('b');

        PriorityQueue pr = new PriorityQueue();
        pr.add('a');
        pr.add('b');
        pr.add('c');

        System.out.println(pr);


    }
}
