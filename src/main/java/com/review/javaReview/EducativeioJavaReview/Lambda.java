package com.review.javaReview.EducativeioJavaReview;

public class Lambda {
    public static void main(String[] args) {
        Greeting hindiGreeting = new HindiGreeting();
        WellWisher ww = new WellWisher();
        ww.wish(() -> System.out.println("Namaste"));


    }

}

@FunctionalInterface
interface Greeting {
    void greet();
}

class HindiGreeting implements Greeting {
    @Override
    public void greet() {
        System.out.println("This is hindi greeting");
    }
}

class TamilGreeting implements Greeting {
    @Override
    public void greet() {
        System.out.println("This is Tamil greeting");
    }
}

class WellWisher {
    public static void wish(Greeting greeting) {
        greeting.greet();
    }

}

