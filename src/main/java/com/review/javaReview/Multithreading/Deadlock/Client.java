package com.review.javaReview.Multithreading.Deadlock;

public class Client {
    public static void main(String args[]) {
        Account fromAccount = new Account(10);
        Account toAccount = new Account(10);


        fromAccount.transfer(fromAccount, toAccount, 5);
        toAccount.transfer(toAccount, fromAccount, 2);

    }
}
