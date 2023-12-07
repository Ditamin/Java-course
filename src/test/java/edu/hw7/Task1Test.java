package edu.hw7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void incrementTest() {
        Task1.Counter counter = new Task1.Counter();

        for (int i = 0; i < 10; ++i) {
            counter.increment();
        }

        Assertions.assertThat(counter.getCounter()).isEqualTo(10);
    }

    @Test
    void twoThreadTest() {
        Task1.Counter counter = new Task1.Counter();

        var thread1 = new Thread(() -> {
            for (int i = 0; i < 20000; ++i) {
                counter.increment();
            }
        });

        var thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; ++i) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertThat(counter.getCounter()).isEqualTo(30000);
    }
}
