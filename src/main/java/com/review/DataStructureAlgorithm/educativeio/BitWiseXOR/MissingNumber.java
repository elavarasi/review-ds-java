package com.review.DataStructureAlgorithm.educativeio.BitWiseXOR;

public class MissingNumber {

    public static void main(String[] args) {

        System.out.println(3 ^ 5);

        int[] arr = {1, 3, 4, 5};

        int x1 = 1;
        for (int i = 2; i <= arr.length + 1; i++ ) {
            System.out.println("X1 " + x1);
            System.out.println("i " + i);



            x1 = x1 ^ i;
            System.out.println(x1);

//            System.out.println("inside");
//            System.out.println("inside");
//            System.out.println(x1);
        }

        int x2 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            x2 = x2 ^ arr[i];

        }
        System.out.println("result");
        System.out.println(x1 ^ x2);
    }
}
