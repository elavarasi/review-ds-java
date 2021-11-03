package com.review.javaReview.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.Spliterator;

public class ArrayListDemo {
    public static void main(String args[]) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(3);

        System.out.println(al.size());

        al.remove("ela");
        System.out.println(al.size());
        System.out.println(al);
        System.out.println(al.toString());
        System.out.println(al.toArray());


        LinkedList ll = new LinkedList();
        ll.add("ela");
        ll.add("kanag");

        System.out.println(ll);

        Integer[] a1 = new Integer[al.size()];
        a1 = al.toArray(a1);
        int sum = 0;
        for (int i : a1) sum+=i;
        System.out.println("ela");
        System.out.println(sum);

        //Splititerator
        Spliterator<Integer> s1 = al.spliterator();
        ArrayList<Double> sqrs = new ArrayList<>();
        while(s1.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));
        System.out.println(sqrs);


    }

}
