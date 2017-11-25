package ru.isalnikov.sportloto.completablefuture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * https://tproger.ru/translations/java8-concurrency-tutorial-1/
 *
 */
public class ScheduledThreadPoolTest {

    public ScheduledThreadPoolTest() {
    }

    
    
     @Test
    public void nScheduledThreadPooleTest() throws InterruptedException{
        
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.currentTimeMillis());
        
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(5000);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        
        System.out.printf("\nRemaining Delay: %s ms\n", remainingDelay);
    }
}
