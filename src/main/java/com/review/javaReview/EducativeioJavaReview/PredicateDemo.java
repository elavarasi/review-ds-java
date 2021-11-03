package com.review.javaReview.EducativeioJavaReview;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateDemo {
    static boolean isPersonEligibleToVote(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    public static void main(String[] args) {


        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        System.out.println(fruits);
        fruits.putIfAbsent("banana", 30);
        System.out.println(fruits);

        Stream<Integer> intStream = Stream.of(1,3,4,5,6);
//        intStream.forEach(i -> System.out.println(i));


        intStream
                .distinct()
                .limit(3)
                .forEach(System.out::println);


        List<Integer> l1 = new ArrayList<>();
        l1.add(5);
        l1.add(16);
        l1.add(17);
        l1.add(3);

        Iterator<Integer> i1 = l1.iterator();

        i1.forEachRemaining(p -> System.out.println("Printing here" + p));


        l1.stream()
                .filter(e -> e > 5)
                .forEach(e -> System.out.println(e));


        Person p1 = new Person("Ela", 23, "India");

        // Create a Predicate
        Predicate<Person> greaterThanEighteen = (p) -> {
          return p.getAge() > 18;
        };

        boolean eligible = isPersonEligibleToVote(p1, greaterThanEighteen);
        System.out.println(eligible);

    }


}
