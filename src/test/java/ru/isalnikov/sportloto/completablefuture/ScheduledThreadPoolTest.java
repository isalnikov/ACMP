package ru.isalnikov.sportloto.completablefuture;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * https://tproger.ru/translations/java8-concurrency-tutorial-1/
 *
 */
public class ScheduledThreadPoolTest {

    public ScheduledThreadPoolTest() {
    }

    @Test
    public void nScheduledThreadPoolTest() throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.currentTimeMillis());

        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(15000);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);

        System.out.printf("\nRemaining Delay: %s ms\n", remainingDelay);
    }

    @Test
    public void nunScheduledThreadPoolTest() throws InterruptedException {

        
        DateTimeFormatter formatter
                = DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.MEDIUM);
        
        HashMap<String, ScheduledFuture<?>> futures = new HashMap<>();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Runnable task1 = () -> System.out.println("task1: " + Thread.currentThread().getName() + " " + LocalTime.now().format(formatter));
        Runnable task2 = () -> System.out.println("task2: " + Thread.currentThread().getName() + " " + LocalTime.now().format(formatter));
        Runnable task3 = () -> {
            System.out.println("task3: " + Thread.currentThread().getName() + " " + LocalTime.now().format(formatter));

            
            
            if (atomicInteger.get() > 3) {
                futures.get("task3").cancel(false);
                System.out.println("task3: " + Thread.currentThread().getName() + " DONE");
            }
            
            atomicInteger.incrementAndGet();
        };

        ScheduledFuture<?> future1 = executor.scheduleWithFixedDelay(task1, 0, 1, TimeUnit.SECONDS);
        ScheduledFuture<?> future2 = executor.scheduleWithFixedDelay(task2, 0, 3, TimeUnit.SECONDS);
        ScheduledFuture<?> future3 = executor.scheduleWithFixedDelay(task3, 0, 1, TimeUnit.SECONDS);

        futures.put("task1", future1);
        futures.put("task2", future2);
        futures.put("task3", future3);

        TimeUnit.MILLISECONDS.sleep(10000);

        List<Runnable> list = executor.shutdownNow();

        list.forEach(System.out::println);

    }

}
