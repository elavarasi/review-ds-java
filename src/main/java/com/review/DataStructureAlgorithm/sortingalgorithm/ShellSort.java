package com.review.DataStructureAlgorithm.sortingalgorithm;

public class ShellSort {

    public static void doShellSort(int[] input) {
        int inner, outer;
        long temp;

        int h = 1;  // find initial value of h

        while(h <= input.length / 3) {
            h = h * 3 + 1;
        }

        while(h > 0) {
            for (outer = h; outer<input.length; outer++) {
                temp = input[outer];
                inner = outer;


                while (inner > h - 1 && input[inner - h] >= temp) {
                    input[inner] = input[inner-h];
                    inner -= h;
                }

                input[inner] = (int) temp;
            }
            h = (h-1) / 3;
        }
    }


    public static void main(String args[]) {
        int[] input = new int[] {5,4,6,7,8,2,3,4,4};
        doShellSort(input);
        for (int eachnumber : input) {
            System.out.println(eachnumber);
        }
    }
}
