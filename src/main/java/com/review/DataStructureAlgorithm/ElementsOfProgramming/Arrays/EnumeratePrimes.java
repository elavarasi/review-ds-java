package com.review.DataStructureAlgorithm.ElementsOfProgramming.Arrays;

import java.util.ArrayList;
import java.util.List;

public class EnumeratePrimes {
    public static void main(String args[]) {
//        int num = 18;
//        int num = 2;
          int num = 10;
//        int num = 499979;
//        int noOfPrimes = countPrimes(num);
        int noOfPrimes = betterApproachCountPrime(num);
        System.out.println(noOfPrimes);
    }

    // For a value such as 499979 we will have a time out in this approach.
    public static int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();

        for (int i = 2; i < n; i++) {
            boolean isPrime = true;

            for(int eachPrime : primes) {
                if (i % eachPrime == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                primes.add(i);
            }

        }
        System.out.println(primes);
        return primes.size();
    }


    public static int betterApproachCountPrime(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i+1; j < n; j++) {
                    if (j % i == 0) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        int totalNumberOfPrimes = 0;
        for (int i = 2; i < n; i++ ) {
            if (isPrime[i]) {
                totalNumberOfPrimes ++;
            }
        }
        return totalNumberOfPrimes;
    }


   // Yes, the terminating loop condition can be p < √n, as all non-primes ≥ √n must have already been marked off. When the loop terminates, all the numbers in the table that are non-marked are prime.// The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n). For the more mathematically inclined readers, you can read more about its algorithm complexity on Wikipedia.
    public int countPrimesAcceptedSolution(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) { // Note here we start from i * i and jump to every ith number
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

}


