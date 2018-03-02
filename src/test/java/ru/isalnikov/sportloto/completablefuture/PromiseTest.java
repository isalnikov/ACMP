package ru.isalnikov.sportloto.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.annotation.Annotations.Bad;
import ru.isalnikov.annotation.Annotations.Good;
import ru.isalnikov.annotation.Annotations.Ugly;

public class PromiseTest {

    public PromiseTest() {
    }

    @Test
    public void testFutureGetNow() throws InterruptedException, ExecutionException {

        CompletableFuture<Long> future = CompletableFuture
                .supplyAsync(() -> 42L)
                .thenApply(r -> r + 2017);

        System.out.println(future.getNow(-1L));
        assertEquals(future.get(), future.getNow(-1L));

    }

    @Test
    public void testCompletableFutureVoid() throws InterruptedException, ExecutionException {

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> 42L)
                .thenApply(r -> r + 2017)
                .thenAccept(System.out::println);

        System.out.println(future.get());

    }

    @Test
    public void testCompletableFutureExceptionally() throws InterruptedException, ExecutionException {

        CompletableFuture<Void> f = CompletableFuture
                .supplyAsync(() -> 42L)
                .thenApply(r -> r + 2017)
                //.thenCombineAsync(r -> r + 2017)

                .thenAccept(System.out::println);

        // .exceptionally(Throwable::printStackTrace);
    }

    @Test
    public void testCompletableFutureExceptionallyRt() throws InterruptedException, ExecutionException {

        CompletableFuture<Void> f = new CompletableFuture<>();

        f.completeExceptionally(new RuntimeException("RuntimeException 1"));

        f.exceptionally(e -> {
            System.out.println("RuntimeException 2");
            return null;
        });

        f.thenApply(Function.identity()).exceptionally(e -> {
            System.out.println("RuntimeException 3");
            return null;
        });

        f.get();
    }

    @Test
    public void testCompletableFutureReduce() throws InterruptedException, ExecutionException {

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> 42L)
                .thenCombine(CompletableFuture.supplyAsync(() -> 2017), Math::min)
                .thenAccept(System.out::println);

    }

    @Test
    @Bad // CompletableFuture<CompletableFuture<Long>> заменить это 
    public void testCompletableFutureFaltMapBad() throws InterruptedException, ExecutionException {
        CompletableFuture<CompletableFuture<Long>> cff = CompletableFuture
                .supplyAsync(() -> 42L)
                .thenApply(x -> CompletableFuture.supplyAsync(() -> x + 2017));
    }

    @Test
    @Good
    public void testCompletableFutureFaltMapGood() throws InterruptedException, ExecutionException {

        CompletableFuture<Long> future = CompletableFuture
                .supplyAsync(() -> 42L)
                .thenCompose(x -> CompletableFuture.supplyAsync(() -> x + 2017));

    }

    @Test
    @Good //  нету throws InterruptedException, ExecutionException 
    public void testCompletableFutureJoin() {

        Stream<Integer> stream = Stream.of(1, 2, 3)
                .map(i -> CompletableFuture.supplyAsync(() -> i))
                .map(CompletableFuture::join);

        stream.forEach(System.out::println);

    }

    @Test
    @Good //  нету throws InterruptedException, ExecutionException 
    public void testCompletableFutureParallelJoin() {

        Stream<Integer> stream = Stream.of(1, 2, 3)
                .parallel()
                .map(i -> CompletableFuture.supplyAsync(() -> i))
                .map(CompletableFuture::join);

        stream.forEach(System.out::println);

    }

    @Test
    @Ugly
    //ForkJoinPool(1); GOOD!!!  
    // deadlock if
    //NOT Executors.newSingleThreadExecutor();
    public void testCompletableFutureParallelJoinUgly() throws InterruptedException, ExecutionException {

        //  ExecutorService es = new ForkJoinPool(1);
        ExecutorService es = Executors.newSingleThreadExecutor();

        Future<?> task = es.submit(() -> {
            try {
                es.submit(() -> System.out.println("1")).get();

            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e);
            }
        });

        task.get();

    }

    @Test
    @Good

    public void testGoodCompletableFuture() throws InterruptedException, ExecutionException {

        CompletableFuture<Long> future = getValue42();

        System.out.println(future.get());

    }

    /**
     * ТODO если будет ошибка то вернктся 1 промис ,отрбаоатет но вернет все
     * раврно 1 раз
     *
     * региональный таск не отменяется -
     *
     * @return
     */
    ScheduledExecutorService es = Executors.newScheduledThreadPool(1);

    public CompletableFuture<Long> getValue42() {
        CompletableFuture<Long> promise = new CompletableFuture<>();

        // Эта такс на канцеляется 
        CompletableFuture.runAsync(() -> {
            try {
                //Thread.sleep(20000);
                promise.complete(new Long(42));
            } catch (Exception e) {
                promise.completeExceptionally(e);
            }

        });

        es.schedule(() -> promise.completeExceptionally(new TimeoutException()), 1, TimeUnit.SECONDS);

        return promise;
    }

    public CompletableFuture<Long> getValue42Timeout() {
        CompletableFuture<Long> promise = new CompletableFuture<>();

        // Эта такс на канцеляется
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                //Thread.sleep(20000);
                promise.complete(new Long(42));
            } catch (Exception e) {
                promise.completeExceptionally(e);
            }

        });

        es.schedule(() -> {
            future.cancel(true);
            promise.completeExceptionally(new TimeoutException());
        }, 1, TimeUnit.SECONDS);

        return promise;
    }

    
    @Test
    public void testGetValue42Timeout() throws InterruptedException, ExecutionException{
        System.out.println(getValue42().get());
        System.out.println(getValue42Timeout().get());
    }
    
}
