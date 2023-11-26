package edu.hw7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    long billion = 1_000_000_000;
    long hundredMillions = 100_000_000;
    long tenMillions = 10_000_000;
    int threadAmount = 6;

    @Test
    void calculatePiError() throws InterruptedException {
        long n = tenMillions;
        double pi = 3.1415926535;
        double error = 0;

        for (int i = 0; i < 10; ++i) {
            error = Math.max(error, Math.abs(pi - Task4.calculatePiSomeThread(n, 1)));
        }

        System.out.println("Количество симуляций: " + n);
        System.out.println("Погрешность: " + error);

        error = 0;
        n = hundredMillions;

        for (int i = 0; i < 10; ++i) {
            error = Math.max(error, Math.abs(pi - Task4.calculatePiSomeThread(n, 1)));
        }

        System.out.println("Количество симуляций: " + n);
        System.out.println("Погрешность: " + error);

        error = 0;
        n = billion;

        for (int i = 0; i < 10; ++i) {
            error = Math.max(error, Math.abs(pi - Task4.calculatePiSomeThread(n, 1)));
        }

        System.out.println("Количество симуляций: " + n);
        System.out.println("Погрешность: " + error);
    }

    @Test
    void differentBetweenOneAndSixThread() throws InterruptedException {
        var start1 = System.nanoTime();
        Task4.calculatePiSomeThread(hundredMillions, 1);
        var end1 = System.nanoTime();
        var start6 = System.nanoTime();
        Task4.calculatePiSomeThread(hundredMillions, threadAmount);
        var end6 = System.nanoTime();
        System.out.println(1d * (end1 - start1) / (end6 - start6));
    }
}
