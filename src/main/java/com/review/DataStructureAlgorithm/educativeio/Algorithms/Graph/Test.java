package com.review.DataStructureAlgorithm.educativeio.Algorithms.Graph;

import java.util.*;

public class Test {

    public static void main(String args[]) {

//        PriorityQueue<Product> queue = new PriorityQueue<Product>((a, b) -> b.noOfItemsSold - a.noOfItemsSold == 0 ? a.price - b.price :  b.noOfItemsSold - a.noOfItemsSold);
//        queue.add(new Product("ela", 2, 4));
//        queue.add(new Product("harshitha", 3, 4));
//        queue.add(new Product("tharah", 2, 6));
//        queue.add(new Product("kanag", 4, 7));

        LinkedList<Product> list1 = new LinkedList<Product>();
        list1.add(new Product("ela", 2, 7));
        list1.add(new Product("harshitha", 3, 4));
        list1.add(new Product("tharah", 2, 6));
        list1.add(new Product("kanag", 4, 7));

        Collections.sort(list1, (o1, o2) -> {
            if (o2.noOfItemsSold - o1.noOfItemsSold == 0) {
                return o1.price - o2.price;
            }
            return o2.noOfItemsSold - o1.noOfItemsSold;
        });

        Iterator<Product> itr1 = list1.iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next().name);
        }

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

    static class Product {
        String name;
        int noOfItemsSold;
        int price;

        Product(String s, int n, int p) {
            name = s;
            noOfItemsSold = n;
            price = p;
        }
    }

}
