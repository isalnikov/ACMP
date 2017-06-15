package ru.isalnikov.sportloto.factorial;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Igor Salnikov 
 */
public class RecursiveForkJoinPoolFactorial {
    
private static class FactorialTask extends RecursiveTask<Long>{
        long n;
        private FactorialTask(long n){
            this.n = n;
        }

        @Override
        protected Long compute() {
            if(n<=1) return 1L;
            FactorialTask ft = new FactorialTask(n-1);
            ft.fork();
            return n * ft.join();
        }
    }

    public long factorial(long n){
        ForkJoinTask<Long> fjt = new FactorialTask(n);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(fjt);
    }

    public static void main(String[] args) {
        long result = new RecursiveForkJoinPoolFactorial().factorial(5);
        System.out.println(result);
    }
}
