package ru.isalnikov.sportloto.completablefuture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * https://tproger.ru/translations/java8-concurrency-tutorial-1/
 *
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("\nRemaining Delay: %s ms", remainingDelay);
    }
}
