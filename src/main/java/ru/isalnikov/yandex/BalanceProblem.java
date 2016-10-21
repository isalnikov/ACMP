package ru.isalnikov.yandex;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BalanceProblem {

  static class Account {

        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

    }
    private static final Object lock = new Object();

    public static void transfer(Account from, Account to, int amount) {
        int fromKey = System.identityHashCode(from);
        int toKey = System.identityHashCode(to);
        if (fromKey < toKey) {
            synchronized (from) {
                synchronized (to) {
                    doTransfer(from, to, amount);
                }
            }
        } else if (fromKey > toKey) {
            synchronized (to) {
                synchronized (from) {
                    doTransfer(from, to, amount);
                }
            }
        } else {
            synchronized (from) {
                synchronized (to) {
                    doTransfer(from, to, amount);
                }
            }

        }

    }

    private static void doTransfer(Account from, Account to, int amount) {

        if (from.getBalance() - amount < 0) {
            throw new IllegalArgumentException("No money!");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

    }

    public static void main(String[] args) throws InterruptedException {

        Account from = new Account();
        from.setBalance(10000);
        
        Account to = new Account();
        to.setBalance(10000);
        
        Random random = new Random(System.currentTimeMillis()/3);
        
        ExecutorService service = Executors.newFixedThreadPool(10);
        AtomicInteger integer = new AtomicInteger(0);
        for (int i = 0; i < 1000; i++) {
         service.execute(()->{
            final  int  amount = 1;// random.nextInt(10)+1;
             System.out.println(integer.incrementAndGet() + " " + Thread.currentThread().getName() + " amount " + amount  +" from : "+ from.getBalance() + " to :"+to.getBalance() );
             transfer(from, to, amount);
         });
            
        }
        
 
        service.awaitTermination(5, TimeUnit.SECONDS);
        service.shutdown();
        
        System.out.println("from "+from.getBalance());
        System.out.println("to   "+to.getBalance());
        
    }

}
