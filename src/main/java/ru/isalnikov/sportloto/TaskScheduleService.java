package ru.isalnikov.sportloto;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * Создать расписание , которое будет исполнять задание по расписанию , 
 * пока флаг задачи актуальный , передавать флаг через ламду 
 * 
 * 
 * 
 * @author Igor Salnikov isalnikov.com
 */

public class TaskScheduleService {

    private final int pool_size = 4;
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(pool_size);
    ConcurrentHashMap<String, ScheduledFuture<?>> futures = new ConcurrentHashMap<>();

    public TaskScheduleService() {
        
    }

    public ScheduledFuture<?> add(
            String name,
            Runnable task,
            long initialDelay,
            long delay,
            TimeUnit unit) {
        ScheduledFuture<?> future = executor.scheduleWithFixedDelay(task, initialDelay, delay, unit);
        futures.put(name, future);

        return future;
    }

}
