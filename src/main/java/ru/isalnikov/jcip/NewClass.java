package ru.isalnikov.jcip;

import java.util.concurrent.CompletableFuture;

/**
 * Java Concurrency in Practice 
 * @author i.salnikov
 */
public class NewClass {
    public static void main(String[] args) {
        AClass a = new ImplClass();
        System.out.println(a.name());
        System.out.println(a.age());
        
        AClass b = new AClass() {
            @Override
            String name() {
                System.out.println(this);
               return this.getClass().getCanonicalName();
            }
        };
        
        System.out.println(b.name());
         System.out.println(a.age());
       
        CompletableFuture<Long> cf1 = CompletableFuture.supplyAsync(() -> 42L);
        
        
    }
}
