package com.review.javaReview.Collections;


import java.util.Iterator;
import java.util.LinkedList;

/*
Linked list implements List, Deque and Queue interface
 */
public class LinkedListDemo {

    public static void main(String args[]) {
        LinkedList<String> l1 = new LinkedList();
        l1.add("edfdfla2");
        l1.add("edfdfla1");
        l1.add("edfdfla3");

        System.out.println(l1);
        Iterator i1 = l1.iterator();
        Iterator i2 = l1.listIterator();
        System.out.println(i1);
        System.out.println(i1.next());
        i1.remove();

        System.out.println(l1);
        System.out.println(i1.next());



    }


}
