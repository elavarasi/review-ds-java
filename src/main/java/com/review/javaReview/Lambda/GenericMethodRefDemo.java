package com.review.javaReview.Lambda;

public class GenericMethodRefDemo {
    static <T> int myOp(MyFunc1<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String args[]) {
        Integer[] vals = {1, 2, 3, 4, 4, 5};
        String[] str = {"one", "two", "three"};

        int count = myOp(MyArrayOps::countMatching, vals, 4);
        System.out.println(count);

    }
}
