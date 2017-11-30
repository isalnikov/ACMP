package ru.isalnikov.sportloto;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class Dice {

    Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Dice dice = new Dice();

        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                dice.callable("task1", 2),
                dice.callable("task2", 1),
                dice.callable("task3", 3));

        String result = executor.invokeAny(callables);
        System.out.println(result);

    }
}
