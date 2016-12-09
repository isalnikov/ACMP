package ru.isalnikov.yandex;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * http://vpros.ru/27940-yava-sinkhronizatsii-atomarno-perevoda-deneg-za-s
 * https://www.securecoding.cert.org/confluence/display/java/LCK07-J.+Avoid+deadlock+by+requesting+and+releasing+locks+in+the+same+order
 */
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

        methodTransferABC();

    }

//    
//public void transfer(Account acc1, Account acc2, BigDecimal value) {
// 
//    Object lock1 = System.identityHashCode(acc1) < System.identityHashCode(acc2) ? acc1.LOCK : acc2.LOCK;
//    Object lock2 = System.identityHashCode(acc1) < System.identityHashCode(acc2) ? acc2.LOCK : acc1.LOCK;
//    synchronized (lock1) {
//       synchronized (lock2) {
//          acc1.widrawal(value);
//          acc2.send(value);
//       }
//    }
//}

    public static void methodTransfer() throws InterruptedException {
        Account from = new Account();
        from.setBalance(10000);

        Account to = new Account();
        to.setBalance(10000);

        Random random = new Random();
        
        ExecutorService service = Executors.newFixedThreadPool(10);
        AtomicInteger integer = new AtomicInteger(0);
        for (int i = 0; i < 1000; i++) {
            service.execute(() -> {
                final int amount = 1;
                System.out.println(integer.incrementAndGet() + " " + Thread.currentThread().getName() + " amount " + amount + " from : " + from.getBalance() + " to :" + to.getBalance());
                transfer(from, to, amount);
                try {
                    Thread.sleep(random.nextInt(50)+200);
                    
                } catch (Exception e) {
                }
            });

        }

        service.awaitTermination(5, TimeUnit.SECONDS);
        service.shutdown();

        System.out.println("from " + from.getBalance());
        System.out.println("to   " + to.getBalance());
    }
    
    public static void methodTransferABC() throws InterruptedException {
        Account A = new Account();
        A.setBalance(10000);

        Account B = new Account();
        B.setBalance(10000);

        Account C = new Account();
        C.setBalance(10000);

        
        
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            service.execute(() -> {
                final int amount = 1;
                transfer(A, B, amount);
               
                
            });
            service.execute(() -> {
                final int amount = 1;
               
                transfer(B, C, amount);
                
            });
            service.execute(() -> {
                final int amount = 1;
                
                transfer(C, A, amount);
                transfer(C, A, amount);
               
            });

        }

        service.awaitTermination(5, TimeUnit.SECONDS);
        service.shutdown();

        System.out.println("A   " + A.getBalance());
        System.out.println("B   " + B.getBalance());
        System.out.println("C   " + C.getBalance());
    }
    
}
