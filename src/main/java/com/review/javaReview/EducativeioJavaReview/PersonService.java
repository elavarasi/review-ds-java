package com.review.javaReview.EducativeioJavaReview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ela", 15, "India"));
        persons.add(new Person("Shree", 17, "USA"));
        persons.add(new Person("Kanag", 16, "SriLanka"));


        System.out.println(persons);

        List<Person> sortedPerson = getPersons(persons);

        System.out.println(persons);
        for(Person eachPerson : sortedPerson) {
            System.out.println(eachPerson.getName());
        }

        for(Person eachPerson : persons) {
            System.out.println(eachPerson.getName());
        }

    }


    public static List<Person> getPersons(List<Person> persons) {
        for(Person eachPerson : persons) {
            System.out.println(eachPerson.getName());
        }
        Collections.sort(persons, (p1, p2) -> {
                return p1.getName().compareTo(p2.getName());
        });

        for(Person eachPerson : persons) {
            System.out.println(eachPerson.getName());
        }


        return persons;
    }

}
