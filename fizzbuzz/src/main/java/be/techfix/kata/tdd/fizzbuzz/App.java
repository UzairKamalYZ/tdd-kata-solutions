package be.techfix.kata.tdd.fizzbuzz;

public class App {

    public static void main(String[] args) {
        App app = new App();
        for (int i = 0; i<=100; i++) {
            System.out.println(app.fizzbuzz(i));
        }
    }

    String fizzbuzz(int i) {
        if (isFizzBuzz(i)) {
            return "fizzbuzz";
        }
        if (isFizz(i)) {
            return "fizz";
        }
        if (isBuzz(i)) {
            return "buzz";
        }
        return ""+i;
    }

    private boolean isBuzz(int i) {
        return isDivisableBy(i, 5);
    }

    private boolean isFizz(int i) {
        return isDivisableBy(i, 3);
    }

    private boolean isFizzBuzz(int i) {
        return isDivisableBy(i, 3 ) && isDivisableBy(i, 5);
    }

    boolean isDivisableBy(int i, int denominator) {
        return i% denominator == 0;
    }

}
