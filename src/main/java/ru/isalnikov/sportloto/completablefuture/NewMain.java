package ru.isalnikov.sportloto.completablefuture;

import java.util.concurrent.CompletableFuture;

public class NewMain {

    public static void main(String[] args) {

        CompletableFuture<Long> future = CompletableFuture
                .supplyAsync(() -> 42L)
                .thenApply(r -> r + 2017);

        
        System.out.println(future.getNow(-1L));
        
    }

}
