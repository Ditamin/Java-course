package edu.hw7;

import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Task4 {
    private Task4() {}

    private final static double R = 1;
    private final static double X_0 = 1;
    private final static double Y_0 = 1;
    private final static double K = 4;

    public static double calculatePiSingleThread(long totalCount) {
        SecureRandom random = new SecureRandom();
        long circleCount = 0;

        for (long i = 0; i < totalCount; ++i) {
            double x = random.nextDouble() * 2;
            double y = random.nextDouble() * 2;

            if ((x - X_0) * (x - X_0) + (y - Y_0) * (y - Y_0) <= R * R) {
                ++circleCount;
            }
        }

        return K * circleCount / totalCount;
    }

    public static double calculatePiSomeThread(long totalCount, int threadAmount) throws InterruptedException {
        AtomicInteger circleCount = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(threadAmount);

        Runnable piCalculating = () -> {
            for (long i = 0; i * threadAmount < totalCount; ++i) {
                double x = ThreadLocalRandom.current().nextDouble() * 2 * R;
                double y = ThreadLocalRandom.current().nextDouble() * 2 * R;

                if ((x - X_0) * (x - X_0) + (y - Y_0) * (y - Y_0) <= R * R) {
                    circleCount.incrementAndGet();
                }
            }
        };

        var tasks = Stream.generate(() -> CompletableFuture.runAsync(piCalculating, executorService))
            .limit(threadAmount)
            .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(tasks).join();
        executorService.shutdown();
        return K * circleCount.get() / totalCount;
    }
}
