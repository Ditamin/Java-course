package edu.hw7;

import java.util.stream.IntStream;

public class Task2 {
    private Task2() {}

    public static int factorial(int n) {
        return IntStream.rangeClosed(1, n)
            .parallel()
            .reduce(1, ((left, right) -> left * right));
    }
}
