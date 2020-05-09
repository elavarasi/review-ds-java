package com.review.functionalProgramming;

import com.sun.tools.javac.util.List;

import java.util.Arrays;

public class PrintList {
    public static void main(String args[]) {
    //    printAllNumbersInListStructured(List.of(12,9,4,5,6));
        printAllNumbersInListFunctional(List.of(12,9,4,5,6));
    }

    private static void print(int number) {
        System.out.println(number);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
       // numbers.stream().forEach(System.out::println); //method Reference

        numbers.stream()
                .filter(number ->  number%2 == 0)
                .forEach(System.out::println);
    }

    private static boolean isEven(int number) {
        return number%2 == 0;
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for(int number: numbers) {
            System.out.println(number);
        }
    }
}
