package com.review.DataStructureAlgorithm.educativeio.Algorithms.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Test {

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int target = 3;


        System.out.println(list.size());
        System.out.println(list.get(0));
        list.remove(target);

        Iterator itr = list.iterator();
        int i = 0;
        while(itr.hasNext()) {
            itr.next();
            if (i == target - 1) {
                itr.remove();
                break;
            }
            i++;
        }

        for (Integer eachItem : list) {
            System.out.println(eachItem);
        }

    }

}
