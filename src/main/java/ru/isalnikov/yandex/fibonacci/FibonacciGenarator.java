package ru.isalnikov.yandex.fibonacci;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Напишите реализацию класса с неблокирующим методом BigInteger next(), который
 * возвращает элементы последовательности: [1, 2, 4, 8, 16, ...]. Код должен
 * корректно работать в многопоточной среде.
 *
 */
public class FibonacciGenarator {

   static class FibonacciEntity {

        private final BigInteger prev;
        private final BigInteger cur;

        FibonacciEntity(BigInteger prev, BigInteger cur) {
            this.prev = prev;
            this.cur = cur;
        }

        BigInteger getPrev() {
            return prev;
        }

        BigInteger getCur() {
            return cur;
        }
    }
    
    
    interface FibonacciCounter {

        BigInteger next();
    }
    
    
    
static class FibonacciCounterImpl implements FibonacciCounter {
    
    private final  AtomicReference<FibonacciEntity> ref = new AtomicReference<>(new FibonacciEntity(BigInteger.ZERO, BigInteger.ONE));
    
    @Override
    public BigInteger next() {
        boolean b;
        BigInteger result;
        do{
            FibonacciEntity entity = ref.get();
            BigInteger prev = entity.getPrev();
            BigInteger cur = entity.getCur();
            BigInteger next = prev.add(cur);
            result = next;
            b = ref.compareAndSet(entity, new FibonacciEntity(cur, next));
        } while (!b);
        return result;
    }
}
    
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static BigInteger current = BigInteger.ONE;
    
    
//    public static BigInteger next() {
//        BigInteger currentRet = current;
//        synchronized (TWO) {
//            current = current.multiply(TWO);
//        }
//        return currentRet;
//    }
    
    public static void main(String[] args) {

        FibonacciCounter impl = new FibonacciCounterImpl();
        for (int i = 0; i < 10; i++) {
            System.out.println(impl.next());
            
        }
       
        
    }

}
