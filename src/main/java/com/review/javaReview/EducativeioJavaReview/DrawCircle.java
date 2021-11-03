package com.review.javaReview.EducativeioJavaReview;

import java.awt.*;
import java.util.Stack;


public class DrawCircle {
    static Canvas c;

    public static void main(String[] args) {

        Math.min(15, 20);
        Stack st = new Stack<>();


        int x = 5;
        int y = 5;

        // The ++ operator changes the value
        //  of the variable, but you can also
        //  use the result in an expression:

        System.out.println(x++);  // post-increment
        System.out.println(++y);  // pre-increment

        // assignment statements are also expressions.
        //  However, the code below is bad: it's too likely
        //  to be a typo; probably you wanted ==, the
        //  the equality comparison.
        System.out.println(x = y);

        // Truly horrible programming style:
        System.out.println(x += (y-- - (x = 4) ));








        float i = 5 + 2.4f;
        System.out.println(i);


        int I = 5;
        System.out.println(42 + 22 + " is my favorite \t num\nber.");
        System.out.format("My favourite number is %3.3f", 3.141592654);

        System.out.format("%2d %2d %2d\n", 4, 6, 8);
        System.out.format("%2d %2d %2d\n", 8, 12, 16);

        System.out.println("\"Good\", said the boy, for " +
                "he had no wish to tell " +
                "the secret to his playmates, "+
                "liking to know and do what " +
                "they knew not and could not.");

        c = new Canvas();
        drawMouth();
    }

    public static void drawMouth() {
        System.out.println();
//        c.update();
    }

}
