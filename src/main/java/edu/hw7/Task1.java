package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private Task1() {}

    public static class Counter {
        private static AtomicInteger counter = new AtomicInteger(0);

        synchronized void increment() {
            counter.incrementAndGet();
        }

        public int getCounter() {
            return counter.get();
        }
    }
}
