package ru.isalnikov.sportloto.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class CompletableFutureAny {
    
   public static ExecutorService pool = Executors.newFixedThreadPool(9);

    public static int getValue() {
        int time = ThreadLocalRandom.current().nextInt(1000);
        System.out.println(String.format("Thread  %s; time = %03d ms", Thread.currentThread().getName(), time));
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }

        return time;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> getValue());
//
//        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> getValue());
//
//        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> getValue());
//
//        CompletableFuture[] arr = new CompletableFuture[]{cf1, cf2, cf3};

        Supplier<CompletableFuture<Integer>> scf = () -> CompletableFuture.supplyAsync(() -> getValue(),pool);

        CompletableFuture[] lst = Stream.generate(scf).limit(9).toArray(CompletableFuture[]::new);

        System.out.println(CompletableFuture.anyOf(lst).get());
        
        pool.shutdown();

    }

}
